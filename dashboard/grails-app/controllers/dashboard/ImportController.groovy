package dashboard

import org.springframework.dao.DataIntegrityViolationException

class ImportController {
def scaffold = true
 
    def delete(Long id) {
        def importInstance = Import.get(id)
        if (!importInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'import.label', default: 'Import'), id])
            redirect(action: "list")
            return
        }

        try {
            importInstance.delete(flush: true)
            def importid= importInstance.importid
            Product.where { importid == importid }.deleteAll()
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'import.label', default: 'Import'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'import.label', default: 'Import'), id])
            redirect(action: "show", id: id)
        }
    }

    def save = {
		def importInstance = new Import(params)
		if (importInstance.save(flush: true, failOnError:true)) {
			flash.message = "Import failed, Download errors for more detail"
			if (session.failure.equals("no errors found")){
				flash.message = "Import Completed, No errors"
			}
			redirect(action: "show", id: importInstance.id)
		}
		else {
			render(view: "create", model: [importInstance: importInstance])
		}
	}
}
