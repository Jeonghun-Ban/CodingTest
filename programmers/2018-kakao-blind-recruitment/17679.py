from typing import List


def solution(m, n, board):
  answer = 0
  board = list(map(list, board))

  while True:
    removed = remove_blocks(m, n, board)
    if removed == 0:
      break
    answer += removed
    move_down(board)

  return answer

def remove_blocks(m, n, board: List[List[str]]) -> int:
  """
  Remove blocks and return the number of removed blocks.
  :param m:
  :param n:
  :param board:
  :return: the number of removed blocks
  """
  indexes = set()
  for y in range(m-1):
    for x in range(n-1):
      indexes.update(removal_indexes(x, y, board))

  index_list = list(indexes)
  index_list.sort(key=lambda x: x[1])
  for x, y in index_list:
    board[y][x] = ' '

  return len(indexes)


def removal_indexes(x, y, board) -> set:
  """
  Return the indexes of blocks to be removed.
  :param x:
  :param y:
  :param board:
  :return: the indexes of blocks to be removed
  """
  indexes = set()

  if (board[y][x] != ' ') and \
      (board[y][x] == board[y][x+1] == board[y+1][x] == board[y+1][x+1]):
    indexes.add((x, y))
    indexes.add((x+1, y))
    indexes.add((x, y+1))
    indexes.add((x+1, y+1))

  return indexes


def move_down(board: List[List[str]]) -> None:
  """
  Move blocks down.
  :param board:
  """
  for x in range(len(board[0])):
      for y in range(len(board) - 1, 0, -1):
        if board[y][x] == ' ':
          for i in range(y-1, -1, -1):
            if board[i][x] != ' ':
              board[y][x] = board[i][x]
              board[i][x] = ' '
              break
