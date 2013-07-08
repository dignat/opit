package dashboard



import org.junit.*
import grails.test.mixin.*

@TestFor(VirtualMachineStatsController)
@Mock(VirtualMachineStats)
class VirtualMachineStatsControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/virtualMachineStats/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.virtualMachineStatsInstanceList.size() == 0
        assert model.virtualMachineStatsInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.virtualMachineStatsInstance != null
    }

    void testSave() {
        controller.save()

        assert model.virtualMachineStatsInstance != null
        assert view == '/virtualMachineStats/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/virtualMachineStats/show/1'
        assert controller.flash.message != null
        assert VirtualMachineStats.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/virtualMachineStats/list'

        populateValidParams(params)
        def virtualMachineStats = new VirtualMachineStats(params)

        assert virtualMachineStats.save() != null

        params.id = virtualMachineStats.id

        def model = controller.show()

        assert model.virtualMachineStatsInstance == virtualMachineStats
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/virtualMachineStats/list'

        populateValidParams(params)
        def virtualMachineStats = new VirtualMachineStats(params)

        assert virtualMachineStats.save() != null

        params.id = virtualMachineStats.id

        def model = controller.edit()

        assert model.virtualMachineStatsInstance == virtualMachineStats
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/virtualMachineStats/list'

        response.reset()

        populateValidParams(params)
        def virtualMachineStats = new VirtualMachineStats(params)

        assert virtualMachineStats.save() != null

        // test invalid parameters in update
        params.id = virtualMachineStats.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/virtualMachineStats/edit"
        assert model.virtualMachineStatsInstance != null

        virtualMachineStats.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/virtualMachineStats/show/$virtualMachineStats.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        virtualMachineStats.clearErrors()

        populateValidParams(params)
        params.id = virtualMachineStats.id
        params.version = -1
        controller.update()

        assert view == "/virtualMachineStats/edit"
        assert model.virtualMachineStatsInstance != null
        assert model.virtualMachineStatsInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/virtualMachineStats/list'

        response.reset()

        populateValidParams(params)
        def virtualMachineStats = new VirtualMachineStats(params)

        assert virtualMachineStats.save() != null
        assert VirtualMachineStats.count() == 1

        params.id = virtualMachineStats.id

        controller.delete()

        assert VirtualMachineStats.count() == 0
        assert VirtualMachineStats.get(virtualMachineStats.id) == null
        assert response.redirectedUrl == '/virtualMachineStats/list'
    }
}
