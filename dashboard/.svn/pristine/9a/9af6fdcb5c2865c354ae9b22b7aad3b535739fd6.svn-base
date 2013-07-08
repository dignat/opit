package axis

class SourceScriptController {
	
	def grailsApplication
	
	//def scaffold = true
	
	def types = [string:'text', set:'set', long:'number', integer:'number']
	
	
	def index = {
	
		def sb = new StringBuilder()
		def omit = ['id', 'version']
		grailsApplication.getDomainClasses().each {
			sb << 'Entity: ' + it.getName() + '<br>'
			def hasMany = []
			it.properties.each {
				def name = it.getName()
				if ( !omit.contains(name) ) {
					def type = it.getTypePropertyName() 
					if (type.equals('set')) {
						def reftype =it.getReferencedPropertyType().toString()
						hasMany << reftype.substring(reftype.lastIndexOf('.')+1)
					}
					else {
						sb << it.getName()
						sb << ' as '
						if (types[type])
							sb << types[type]
						else
							sb << type.capitalize()
						sb << '<br>'
					}
				}
				it.metaClass.methods.each {
				//	sb << it
				//	sb << '<br>'
				}
			}
			if (hasMany) {
				sb << 'Has Many: '
				sb << hasMany.join(', ')
				sb << '<br>'
			}
			sb << '<br>'
		}
		render sb

		grailsApplication.getControllerClasses().each {
			render "$it<br>"
		}
		
		grailsApplication.getServiceClasses().each {
			render "$it<br>"
		}
				
	} 
	
	def getcsv = {
		def csv = new StringBuilder()
		def omit = ['id', 'version']
		grailsApplication.getDomainClasses().each {
			csv << it.getFullName()
			csv << ','
			it.properties.each {
				def name = it.getName()
				if ( !omit.contains(name) ) {
					csv << it.getTypePropertyName()
					csv << ' '
					csv << it.getName()
					csv << ','
				}
			}
			def last = csv.size() - 1
			csv.putAt(new IntRange(last, last), '\n')
		}
		response.setHeader("Content-disposition", "attachment; filename=metadata.csv")
		render(contentType: "text/csv", text: "${csv}")
	}

}
