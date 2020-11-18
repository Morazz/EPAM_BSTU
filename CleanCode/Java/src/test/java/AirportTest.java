import Planes.ExperimentalPlane;
import models.ClassificationLevel;
import models.ExperimentalTypes;
import models.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.Arrays;
import java.util.List;

public class AirportTest {
    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-81 Vertijet", 560, 307, 500, ExperimentalTypes.VTOL, ClassificationLevel.TOP_SECRET),
            new ExperimentalPlane("Ryan Z-13 Vertijet", 780, 541, 250, ExperimentalTypes.LIFTING_BODY, ClassificationLevel.UNCLASSIFIED),
            new ExperimentalPlane("Ryan VV-13 Vertijet", 900, 409, 678, ExperimentalTypes.HYPERSONIC, ClassificationLevel.CONFIDENTIAL)
    );

    private static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);

    @Test
    public void GetTransportMilitaryPlanesTest() {
        Airport airport = new Airport(planes);
        List<MilitaryPlane> transportMilitaryPlanes = airport.GetTransportMilitaryPlanes();
        boolean flag = false;
        for (MilitaryPlane militaryPlane : transportMilitaryPlanes) {
            if ((militaryPlane.GetType() == MilitaryType.TRANSPORT)) {
                flag = true;
                break;
            }
        }
        Assert.assertEquals(flag, true);
    }

    @Test
    public void GetPassengerPlaneWithMaxCapacityTest() {
        Airport airport = new Airport(planes);
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.GetPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertTrue(expectedPlaneWithMaxPassengersCapacity.equals(planeWithMaxPassengerCapacity));
    }

    @Test
    public void GetModelTest(){
        Assert.assertNotNull(planes.get(1).GetPlaneModel());
    }

    @Test
    public void GetPassengersCapasityTest(){
        Assert.assertNotNull(planeWithMaxPassengerCapacity.GetPassengersCapacity());
    }

    @Test
    public void SortByMaxSpeedTest(){
        Airport airport = new Airport(planes);
        airport.SortByMaxSpeed();
        List<? extends Plane> planesSortedByMaxSpeed = airport.GetPlanes();

        boolean nextPlaneMaxSpeedIsHigherThanCurrent = true;
        for (int i = 0; i < planesSortedByMaxSpeed.size() - 1; i++) {
            Plane currentPlane = planesSortedByMaxSpeed.get(i);
            Plane nextPlane = planesSortedByMaxSpeed.get(i + 1);
            if (currentPlane.GetMaxSpeed() > nextPlane.GetMaxSpeed()) {
                nextPlaneMaxSpeedIsHigherThanCurrent = false;
                break;
            }
        }
        Assert.assertTrue(nextPlaneMaxSpeedIsHigherThanCurrent);
    }

    @Test
    public void GetNextPlaneMaxLoadCapacityIsHigherThanCurrentTest() {
        Airport airport = new Airport(planes);
        airport.SortByMaxLoadCapacity();
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.GetPlanes();

        boolean nextPlaneMaxLoadCapacityIsHigherThanCurrent = true;
        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
            Plane currentPlane = planesSortedByMaxLoadCapacity.get(i);
            Plane nextPlane = planesSortedByMaxLoadCapacity.get(i + 1);
            if (currentPlane.GetMinLoadCapacity() > nextPlane.GetMinLoadCapacity()) {
                nextPlaneMaxLoadCapacityIsHigherThanCurrent = false;
                break;
            }
        }
        Assert.assertTrue(nextPlaneMaxLoadCapacityIsHigherThanCurrent);
    }

    @Test
    public void HasAtLeastOneBomberInMilitaryPlanesTest() {
        Airport airport = new Airport(planes);
        List<MilitaryPlane> bomberMilitaryPlanes = airport.GetBomberMilitaryPlanes();
        boolean flag = false;
        for (MilitaryPlane militaryPlane : bomberMilitaryPlanes) {
            if ((militaryPlane.GetType() == MilitaryType.BOMBER)) {
                flag = true;
            }
            else {
                Assert.fail("Test failed!");
            }
        }
    }

    @Test
    public void ExperimentalPlanesHasClassificationLevelHigherThanUnclassifiedTest(){
        Airport airport = new Airport(planes);
        List<ExperimentalPlane> experimentalPlanes = airport.GetExperimentalPlanes();
        boolean hasUnclassifiedPlanes = false;
        for(ExperimentalPlane experimentalPlane : experimentalPlanes){
            if(experimentalPlane.GetClassificationLevel() == ClassificationLevel.UNCLASSIFIED){
                hasUnclassifiedPlanes = true;
                break;
            }
        }
        Assert.assertFalse(hasUnclassifiedPlanes);
    }
}
