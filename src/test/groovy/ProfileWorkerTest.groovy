import com.google.gson.Gson
import com.novokreshchenovleo.test2gis.model.Profile
import com.novokreshchenovleo.test2gis.service.Requester
import com.novokreshchenovleo.test2gis.service.worker.implementation.ProfileWorkerImpl
import spock.lang.Specification

class ProfileWorkerTest extends Specification {
    def "TestCall"() {
        given:
        def request = Mock(Requester)
        def profileWorker = new ProfileWorkerImpl("test", "test", "test", "test");
        def testProfile = new Profile();
        testProfile.setName("test_name");
        testProfile.setAddress("test_address")
        testProfile.setCityName("test_city")
        testProfile.setRating(1.3)
        request.get(_) >> new Gson().toJson(testProfile)
        profileWorker.setRequester((Requester) request)

        when:
        def profile = profileWorker.call()

        then:
        profile.getName() == "test_name";
        profile.getAddress() == "test_address";
        profile.getCityName() == "test_city";
        profile.getRating() == 1.3f;
    }
}