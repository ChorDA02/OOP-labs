import java.util.*;

public class AStarState
{
    private Map2D map;
    private Map<Location, Waypoint> open_waypoints = new HashMap<Location, Waypoint> ();
    private Map<Location, Waypoint> closed_waypoints = new HashMap<Location, Waypoint> ();
    public AStarState(Map2D map)
    {
        if (map == null) throw new NullPointerException("map cannot be null");
        this.map = map;
    }
    public Map2D getMap()
    {
        return map;
    }
    public Waypoint getMinOpenWaypoint()
    {
        if (numOpenWaypoints() == 0) return null;// открытые вершины отсутствуют
        Set open_waypoint_keys = open_waypoints.keySet(); // инициализируем keyset на все открытые вершины
        Iterator i = open_waypoint_keys.iterator(); // находим лучшую точку и её цену
        Waypoint best = null;
        float best_cost = Float.MAX_VALUE;
        while (i.hasNext()) // ищем открытые вершины
        {
            Location location = (Location)i.next(); // текущая локация
            Waypoint waypoint = open_waypoints.get(location); // текущий waypoint
            float waypoint_total_cost = waypoint.getTotalCost(); // цена текущей позиции
            if (waypoint_total_cost < best_cost) // замена наиболее дешевой вершины и её цены, если найдена более дешевая
            {
                best = open_waypoints.get(location);
                best_cost = waypoint_total_cost;
            }

        }
        return best; //точка с минимальной ценой
    }
    public boolean addOpenWaypoint(Waypoint newWP)
    {
        Location location = newWP.getLocation(); // локация точки
        if (open_waypoints.containsKey(location)) // проверка, является ли точка в выбранной локации открытой вершиной
        {
            Waypoint current_waypoint = open_waypoints.get(location); // проверка, является ли текущая точка более дешевой
            if (newWP.getPreviousCost() < current_waypoint.getPreviousCost())
            {
                open_waypoints.put(location, newWP);// если является, замена старой на новую, более дешевую
                return true;
            }
            return false;
        }
        open_waypoints.put(location, newWP);// добавляем точку в открытые вершины
        return true;
    }
    public int numOpenWaypoints()
    {
        return open_waypoints.size();
    }
    public void closeWaypoint(Location loc)
    {
        Waypoint waypoint = open_waypoints.remove(loc);
        closed_waypoints.put(loc, waypoint);
    }
    public boolean isLocationClosed(Location loc)
    {
        return closed_waypoints.containsKey(loc);
    }
}