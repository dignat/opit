package dashboard
import org.springframework.web.multipart.MultipartFile
import org.codehaus.groovy.grails.web.context.ServletContextHolder

class FileUploadService {

	boolean transactional = true

	def String uploadFile( MultipartFile file, String name, String destinationDirectory){
		def servletContext = ServletContextHolder.servletContext
		def storagePath = servletContext.getRealPath(destinationDirectory)


		def storagePathDirectory = new File(storagePath)
		if(!storagePathDirectory.exists()){
			print "Creating directory ${storagePath}: "

			if(storagePathDirectory.mkdir()){
				println "Success"
			}else{
				println "Failed"
			}
		}

		if(!file.isEmpty()){
			file.transfetTo(new File("${storagePath/$name}"))
			println "Saved file: ${storagePath/$name}"
			return "$storagePath/$name}"
		}else{
			println "File ${file.inspect()} was empty!"

			return null
		}
	}

    
}
