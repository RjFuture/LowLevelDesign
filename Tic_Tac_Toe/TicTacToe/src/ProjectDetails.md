# Tic-Tac-Toe LLD — Project Requirements & Status

## Constraints (fixed for this project)
- Max **1 Bot** per game — enforced in `Game.Builder.validateBotCount()`
- Player count must be **less than board size** — enforced in `validatePlayerNumber()`
- All player symbols must be **unique** — enforced in `validateAllplayer()`
- **No persistence** — game state lives entirely in memory for the duration of one run; nothing is saved to disk/DB, no resume-after-restart
- Board is **N×N**, configurable size, entered by the client at game start
- 2 to (size - 1) players supported, mix of Human and at most 1 Bot

---

## ✅ Already implemented

### Core domain
- `Player` (abstract) → `Human`, `Bot`
- `Symbol` — with `equals()`/`hashCode()` overridden (value-based uniqueness check)
- `Cell` — row, col, `CellState` (EMPTY/FILLED), owning `Player`
- `Board` — N×N grid of `Cell`, `display()`
- `Move` — records `Player` + `Cell` for a single turn
- `Game` — holds `Board`, `List<Player>`, `List<Move>` (history), `nextTurn`, `GameState`, winner, list of `WinningStartegy`

### Patterns applied
- **Builder** — `Game.Builder` (static nested class), fluent chaining, validation on `build()`
- **Simple Factory** — `HumanFactory`, `BotFactory`, `BotPlayingStartegyFactory`
- **Strategy** — `WinningStartegy` (Row/Column/Diagonal), `BotPlayingStrategy` (Easy/Medium/Hard)

### Gameplay features
- Turn-based play, round-robin via `nextTurn` index with wraparound
- Move validation (bounds check, cell-already-filled check)
- Win detection via pluggable `WinningStartegy` list, checked after each move
- Draw detection (board full, no winner)
- **Global undo** — pops last `Move`, clears the cell, rolls `nextTurn` back
  - Fixed bug: `WinningStartegy` implementations keep internal per-row/col/diagonal symbol counters — `undo()` must call a corresponding `undoMove()` on every strategy to decrement those counters, or stale counts cause incorrect winner attribution after undo/redo cycles
- Random player turn order via `Collections.shuffle(players)` before game start
- Bot difficulty levels: **Easy** and **Medium** implemented
  - Medium: collect all empty cells, pick one uniformly at random (avoids the retry-loop degrading near full boards)

### Known Java gotchas hit and fixed along the way
- `Scanner.nextInt()` leaves a trailing `\n` unconsumed — must flush with an extra `nextLine()` before any subsequent `nextLine()` call, or the first line-read silently returns empty
- `List.remove(Object)` vs `List.remove(int index)` — use index-based removal when position is known, to avoid relying on `equals()` behavior
- `Move`/`Cell` must hold **references to the actual board cell**, never `new Cell(...)` copies — otherwise mutations (fill/clear) don't reflect on the real board `display()` reads from

---

## 🔲 Remaining: Hard Bot Strategy

**Goal:** Bot should play close to optimally, not randomly.

### Suggested approach (for when you pick this back up)
1. **Win-if-possible check** — before playing randomly, scan all empty cells: if placing the bot's symbol in any of them would win immediately, play there.
2. **Block-if-necessary check** — if no immediate win exists, scan all empty cells: if the opponent could win next turn by playing there, block it by playing there instead.
3. **Fallback** — if neither applies, fall back to Medium's random-empty-cell logic (or a simple heuristic like preferring the center cell, then corners, then edges — classic tic-tac-toe heuristic ordering).
4. **(Optional, full-strength)** — Minimax algorithm: recursively simulate all possible future move sequences, score terminal states (win/lose/draw), and pick the move that maximizes the bot's guaranteed outcome. This is the "provably unbeatable" version, but likely overkill unless the assignment specifically asks for optimal play — steps 1–3 already produce a strong, sensible bot without the added complexity.

### Design note
`HardBotPlayingStrategy` should implement the same `BotPlayingStrategy` interface as Easy/Medium — `makeMove(Board board, Player player)` (or whatever the finalized signature is) — so `BotPlayingStartegyFactory` only needs one new branch, and `Bot` itself needs zero changes to support it.

---

## Explicitly out of scope (per your stated constraints)
- No persistence layer (no save/load/resume)
- No more than 1 Bot per game
- No networked/online multiplayer
- No redo (only undo was requested)