import com.google.gson.Gson
import com.novokreshchenovleo.test2gis.model.SearchResult
import com.novokreshchenovleo.test2gis.service.Requester
import com.novokreshchenovleo.test2gis.service.worker.implementation.SearchWorkerImpl
import spock.lang.Specification

class SearchWorkerTest extends Specification {
    def "TestCall"() {
        given:
        def request = Mock(Requester)
        def searchWorker = new SearchWorkerImpl("test", "test", "test", "test", "test");
        request.get(_) >> new Gson().toJson(new SearchResult())
        searchWorker.setRequester((Requester) request)

        when:
        def profile = searchWorker.call()

        then:
        profile != null
    }
}