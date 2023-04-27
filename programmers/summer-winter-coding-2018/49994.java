import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Solution {
  public int solution(String dirs) {
    Set<Load> visit = new HashSet<>();

    Player player = new Player();
    for (char dir : dirs.toCharArray()) {
      player.move(dir, visit);
    }

    return visit.size();
  }

  class Player {
    private Point current;

    public Player() {
      this.current = new Point(0, 0);
    }

    public boolean move(char cmd, Set<Load> visit) {
      int dx[] = {0, 0, 1, -1}; // U, D, R, L
      int dy[] = {1, -1, 0, 0};

      int i = 0;
      switch (cmd) {
        case 'U':
          i = 0;
          break;
        case 'D':
          i = 1;
          break;
        case 'R':
          i = 2;
          break;
        case 'L':
          i = 3;
          break;
      }

      Point next = current.next(dx[i], dy[i]);
      if (next.isOver(-5, 5, -5, 5)) {
        return false;
      }

      visit.add(new Load(current, next));
      this.current = next;
      return true;
    }
  }

  class Road {
    Point from;
    Point to;

    public Road(Point from, Point to) {
      this.from = from;
      this.to = to;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (!(obj instanceof Load)) {
        return false;
      }

      Load load = (Load) obj;
      return (this.from.equals(load.from) && this.to.equals(load.to))
          || (this.from.equals(load.to) && this.to.equals(load.from));
    }

    @Override
    public int hashCode() {
      return Objects.hash(from, to) + Objects.hash(to, from);
    }
  }

  class Point {
    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    private boolean isOver(int minX, int maxX, int minY, int maxY) {
      return this.x < minX || this.x > maxX || this.y < minY || this.y > maxY;
    }

    public Point next(int dx, int dy) {
      return new Point(this.x + dx, this.y + dy);
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (!(obj instanceof Point)) {
        return false;
      }

      Point point = (Point) obj;
      return this.x == point.x && this.y == point.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }
}