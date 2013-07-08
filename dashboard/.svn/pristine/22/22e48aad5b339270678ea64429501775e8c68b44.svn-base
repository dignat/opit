package dashboard

class LoginTagLib {
	def loginControl = {
    if(session.admin){
      out << "Hello ${session.admin.name} "
      out << """[${link(action:"logout", controller:"admin"){"Logout"}}]"""
    } else {
      out << """[${link(action:"login", controller:"admin"){"Login"}}]"""      
    }
  }

}
