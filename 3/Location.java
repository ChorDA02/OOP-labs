public class Location
{
    public int xCoord;
    public int yCoord;
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }
    public Location()
    {
        this(0, 0);
    }
    public boolean equals(Object obj) {
        if (obj instanceof Location) {
            Location other = (Location) obj;
            if (xCoord == other.xCoord && yCoord == other.yCoord) {
                return true;
            }
        }
        return false;
    }
    public int hashCode() {
        int result = 17;
        result = 29 * result + xCoord;
        result = 29 * result + yCoord;
        return result;
    }
}
