def solution(cacheSize, cities):
  answer = 0
  cache = LruCache(cacheSize)

  for city in cities:
    city = city.lower()
    if cache.is_hit(city):
      answer += 1
      cache.update(city)
    else:
      answer += 5
      cache.add(city)

  return answer

class LruCache:
  def __init__(self, size):
    self.size = size
    self.cache = []

  def is_full(self):
    return len(self.cache) == self.size

  def is_hit(self, element):
    if self.size == 0:
      return False
    return element in self.cache

  def add(self, element):
    if self.size == 0:
      return
    if self.is_full():
      self.cache.pop(0)
    self.cache.append(element)

  def update(self, element):
    if self.is_full():
      self.cache.pop(self.cache.index(element))
    self.cache.append(element)
