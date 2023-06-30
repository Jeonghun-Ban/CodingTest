from typing import List


def solution(str1, str2):
  set1 = str_to_multiset(str1)
  set2 = str_to_multiset(str2)

  result = jaccard(set1, set2)
  return int(result * 65536)

def str_to_multiset(s):
  elements = []
  for i in range(len(s) - 1):
    if s[i].isalpha() and s[i + 1].isalpha():
      elements.append(s[i:i + 2].lower())
  return MultiSet(elements)

def jaccard(set1, set2):
  intersection = set1.intersection(set2)
  union = set1.union(set2)
  if len(union) == 0:
    return 1
  return len(intersection) / len(union)


class MultiSet:
  elements = []

  def __init__(self, elements: List[str]):
    self.elements = elements

  def __len__(self):
    return len(self.elements)

  def union(self, other):
    result = self.elements.copy()
    tmp = self.elements.copy()

    for i in other.elements:
      if i in tmp:
        tmp.remove(i)
      else:
        result.append(i)

    return MultiSet(result)

  def intersection(self, other):
    result = []
    tmp = self.elements.copy()

    for i in other.elements:
      if i in tmp:
        tmp.remove(i)
        result.append(i)

    return MultiSet(result)
