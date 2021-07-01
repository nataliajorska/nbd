import com.basho.riak.client.api.RiakClient;
import com.basho.riak.client.api.commands.kv.DeleteValue;
import com.basho.riak.client.api.commands.kv.FetchValue;
import com.basho.riak.client.api.commands.kv.StoreValue;
import com.basho.riak.client.api.commands.kv.UpdateValue;
import com.basho.riak.client.core.RiakCluster;
import com.basho.riak.client.core.RiakNode;
import com.basho.riak.client.core.query.Location;
import com.basho.riak.client.core.query.Namespace;
import com.basho.riak.client.core.query.RiakObject;
import com.basho.riak.client.core.util.BinaryValue;

import java.net.UnknownHostException;

public class Zad8 {

    public static class Wine {
        public String name;
        public String grape;
        public Integer year;

    }

    public static class WineUpdate extends UpdateValue.Update<Wine> {
        private final Wine update;
        public WineUpdate(Wine update){
            this.update = update;
        }

        @Override
        public Wine apply(Wine t) {
            if(t == null) {
                t = new Wine();
            }

            t.grape = update.grape;
            t.year = update.year;
            t.name = update.name;

            return t;
        }
    }

    private static RiakCluster setUpCluster() throws UnknownHostException {

        RiakNode node = new RiakNode.Builder()
                .withRemoteAddress("127.0.0.1")
                .withRemotePort(8087)
                .build();

        RiakCluster cluster = new RiakCluster.Builder(node)
                .build();

        cluster.start();

        return cluster;
    }
    public static void main( String[] args ) {
        try {
            Wine wine = new Wine();
            wine.name = "Champagne";
            wine.grape = "Pinot Gringo";
            wine.year = 1998;
            System.out.println("wine object created");

            RiakCluster cluster = setUpCluster();
            RiakClient client = new RiakClient(cluster);
            System.out.println("Client object successfully created");

            Namespace wineBucket = new Namespace("wines");
            Location champagneLocation = new Location(wineBucket, "Champagne");
            StoreValue storeWineOp = new StoreValue.Builder(wine)
                    .withLocation(champagneLocation)
                    .build();
            client.execute(storeWineOp);
            System.out.println("Champagne information now stored in Riak");

            FetchValue fetchChampagneOp = new FetchValue.Builder(champagneLocation)
                    .build();
            Wine fetchedWine = client.execute(fetchChampagneOp).getValue(Wine.class);
            System.out.println("wine object successfully fetched");

            System.out.println(fetchedWine);

            wine.year = 1995;
            WineUpdate updatedWine = new WineUpdate(wine);
            UpdateValue updateValue = new UpdateValue.Builder(champagneLocation)
                    .withUpdate(updatedWine).build();
            UpdateValue.Response response = client.execute(updateValue);
            fetchedWine = client.execute(fetchChampagneOp).getValue(Wine.class);
            System.out.println("wine object successfully fetched");
            System.out.println(fetchedWine);

            DeleteValue deleteValue = new DeleteValue.Builder(champagneLocation).build();
            client.execute(deleteValue);
            fetchedWine = client.execute(fetchChampagneOp).getValue(Wine.class);
            System.out.println(fetchedWine);

            cluster.shutdown();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}