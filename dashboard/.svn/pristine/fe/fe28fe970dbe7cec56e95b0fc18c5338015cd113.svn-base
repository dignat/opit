package dashboard



import org.junit.*
import grails.test.mixin.*

@TestFor(ImportController)
@Mock(Import)
class ImportControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/import/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.importInstanceList.size() == 0
        assert model.importInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.importInstance != null
    }

    void testSave() {
        controller.save()

        assert model.importInstance != null
        assert view == '/import/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/import/show/1'
        assert controller.flash.message != null
        assert Import.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/import/list'

        populateValidParams(params)
        def import = new Import(params)

        assert import.save() != null

        params.id = import.id

        def model = controller.show()

        assert model.importInstance == import
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/import/list'

        populateValidParams(params)
        def import = new Import(params)

        assert import.save() != null

        params.id = import.id

        def model = controller.edit()

        assert model.importInstance == import
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/import/list'

        response.reset()

        populateValidParams(params)
        def import = new Import(params)

        assert import.save() != null

        // test invalid parameters in update
        params.id = import.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/import/edit"
        assert model.importInstance != null

        import.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/import/show/$import.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        import.clearErrors()

        populateValidParams(params)
        params.id = import.id
        params.version = -1
        controller.update()

        assert view == "/import/edit"
        assert model.importInstance != null
        assert model.importInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/import/list'

        response.reset()

        populateValidParams(params)
        def import = new Import(params)

        assert import.save() != null
        assert Import.count() == 1

        params.id = import.id

        controller.delete()

        assert Import.count() == 0
        assert Import.get(import.id) == null
        assert response.redirectedUrl == '/import/list'
    }
}
