package byog.lab5;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int Width = 60;
    private static final int Height = 50;
    private static final long SEED = 61;
    private static final Random RANDOM = new Random(SEED);
    private static final int s = 4;
    private static final Position beginPos = new Position(30, 0);
    private static final Position[] p = new Position[19];

    public static void main(String[] args) {
        TERenderer renderer = new TERenderer();
        renderer.initialize(Width, Height);
        TETile[][] tiles = new TETile[Width][Height];
        initWorld(tiles, Width, Height);
        setPosition(p, beginPos, s);
        drawHexagons(tiles, s, p);
        renderer.renderFrame(tiles);
    }

    public static void initWorld(TETile[][] world, int width, int height) {
        for (int x = 0; x < width; x += 1) {
            for (int y = 0; y < height; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }
    }

    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(6);
        switch (tileNum) {
            case 0:
                return Tileset.WALL;
            case 1:
                return Tileset.FLOWER;
            case 2:
                return Tileset.TREE;
            case 3:
                return Tileset.GRASS;
            case 4:
                return Tileset.MOUNTAIN;
            case 5:
                return Tileset.WATER;
            default:
                return Tileset.NOTHING;
        }
    }

    public static void drawHexagons(TETile[][] world, int s, Position[] p) {
        for (int i = 0; i < 19; i++) {
            addHexagon(world, p[i], s, randomTile());
        }
    }

    public static void setPosition(Position[] p, Position begin, int s) {
        int index = 0;
        for (int i = 2; i >= 0; i--) {
            int beginX = begin.x - i * (2 * s - 1);
            int beginY = begin.y + i * s;
            for (int j = 0; j < 5 - i; j++) {
                p[index] = new Position(beginX, beginY);
                beginY += 2 * s;
                index++;
            }
        }
        for (int i = 1; i < 3; i++) {
            int beginX = begin.x + i * (2 * s - 1);
            int beginY = begin.y + i * s;
            for (int j = 0; j < 5 - i; j++) {
                p[index] = new Position(beginX, beginY);
                beginY += 2 * s;
                index++;
            }
        }
    }

    public static void addHexagon(TETile[][] world, Position p, int s, TETile t) {
        for (int i = 0; i < s; i++) {
            p.x -= 1;
            p.y += 1;
            for (int j = 0; j < s + 2 * i; j++) {
                world[p.x + j][p.y] = t;
            }
        }
        for (int i = s - 1; i >= 0; i--) {
            p.y += 1;
            for (int j = 0; j < s + 2 * i; j++) {
                world[p.x + j][p.y] = t;
            }
            p.x += 1;
        }
    }
}
