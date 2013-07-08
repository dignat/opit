package dashboard

import javax.net.ssl.*
import groovy.json.*
import java.text.DecimalFormat

class SolidFireStorageController {
	
	def scaffold = true
	
	class CustomizedHostNameVerifier implements HostnameVerifier {
		public boolean verify(String hostname, SSLSession session) {
			return true
		}
	}
	
	def index = {
		def host = '10.30.20.60'
		def username = 'Solidfire'
		def password = 'Pa55word!'
		def index = 1
		def function = 'ListAccounts'
		def args = [startVolumeID:0, limit:1000]
		def json = solidFire(host, username, password, index, function, args)
		json.result.accounts.each {
			it.each {
				render "$it<br>"
			}
		}
		render "------------------------<br>"
		json.result.accounts.volumes.each {
			it.each {
				function = "GetVolumeStats"
				args = [volumeID:it]
				solidFire(host, username, password, index, function, args).result.volumeStats.each {
					def value = getSize(it.key, it.value.toString())
					render "$it.key: $value<br>"					
				}
				render "------------------------<br>"
			}			
		}
		
	}
	
	def getSize(String label, String value) {
		if (!value.isNumber())
			return value
			def x = value.toBigDecimal()
		if (!label.endsWith('Bytes') && !label.endsWith('volumeSize')) {
			def df = new DecimalFormat("###,###,###,##0")
			return df.format(x)			
		}
		def mag = ['bytes', 'Kb', 'Mb', 'Gb', 'Tb']
		def i = 0
		while(x > 999) {
			x /= 1000
			i++
		}
		def df = new DecimalFormat("###,##0.00")
		df.format(x) + ' ' + mag[i]
	}
	
	def solidFire(host, username, password, index, function, args) {
		// Create a trust manager that does not validate certificate chains
		[ new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}
			public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
			}
			public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
			}
		} ] as TrustManager[]
		// Install the all-trusting trust manager
		try {
		    SSLContext sc = SSLContext.getInstance("SSL")
		    sc.init(null, trustAllCerts, new java.security.SecureRandom())
		    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory())
		} 
		catch (Exception e) {	
		}
		// Build the request
		def builder = new groovy.json.JsonBuilder()
		def root = builder {
			method function
			params args
			id index
		}								
		// println builder.toPrettyString()
		// Connect to the server
		def url = "https://${host}/json-rpc/1.0".toURL()
		def connection = url.openConnection()
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json-rpc")
		def logon = "${username}:${password}".toString().bytes.encodeBase64().toString()		
		connection.setRequestProperty("authorization", "Basic " + logon)
		connection.setHostnameVerifier(new CustomizedHostNameVerifier())
		connection.setDoOutput(true)
		def output = new OutputStreamWriter(connection.getOutputStream())
		output.write(builder.toString())
		output.close()
		def input = connection.getInputStream()
		def reader = new BufferedReader(new InputStreamReader(input))
		String line
		def result = new StringBuilder()
		while ((line = reader.readLine())) {
			result << line
		}
		input.close()
		def slurper = new JsonSlurper()
		return slurper.parseText(result.toString())		
	}	
}
