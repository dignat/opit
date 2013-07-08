<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Calligo Dashboard</title>
		<style type="text/css" media="screen">
			#status {
				background-color: transparent;
				border: .0em solid #fff;
				margin: 11em 15em 1em;
				padding: 1em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
				position: absolute;/*added for chrome and safari*/
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}
            
			#status li {
				line-height: 1.3;
				text-align: center;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}
			#status1 {
				background-color: transparent;
				border: .0em solid #fff;
				margin: 11em 30em 1em;
				padding: 1em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
				position: absolute;/*added for chrome and safari*/
			}
			
			

			#status1 ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}
            
			#status1 li {
				line-height: 1.3;
				text-align: center;
			}

			#status1 h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}
			#status2 {
				background-color: transparent;
				border: .0em solid #fff;
				margin: 11em 45em 1em;
				padding: 1em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
				position: absolute;/*added for chrome and safari*/
			}
			
			

			#status2 ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}
            
			#status2 li {
				line-height: 1.3;
				text-align: center;
			}

			#status2 h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}

			#page-body {
				margin: 2em 1em 1.25em 18em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;

			}


			h3 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 3em;
				color:red;
				font-weight: bold;
				width :100px;
			}

			h4 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 3em;
				color:green;
				font-weight: bold;
				width :100px;
				
			}

			p {
				line-height: 1.5;
				margin: 0.25em 0;
				color: #fff;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status,#status1,#status2 {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
			#cover{
				margin: 0 auto; height: 720px; background-color: #444;
			}
			dl {
  line-height: 2;
  display: inline-block;
  position: relative;
}

dt {
  text-align: right;
  margin-right: 1em;
}
dd {
  position: absolute;
  left: 100%;
  margin-top: -3em; /* negate the DL line-height */
  white-space: nowrap; /* without this, DDs will be the same length as DTs*/
}



		</style>
	</head>
	<body>


		

		<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<h2>Administration Tasks:</h2>
		<div id="status" >
			
			<ul>
				<li><a href="${createLink(controller: 'role',action: 'list')}"> <img src="${resource(dir: 'images', file: 'User-Role-Guest-icon.png')}" alt="Client"/><br>Manage Roles </li>
				<li><a href="${createLink(controller: 'user',action: 'list')}"> <img src="${resource(dir: 'images', file: 'Users-icon.png')}" alt="Calligo"/><br>Manage Users</li></a>
				<li><a href="${createLink(controller: 'client',action: 'list')}"> <img src="${resource(dir: 'images', file: 'man-icon.png')}" alt="Calligo"/></br>Manage Clients</li></a>
				<li><a href="${createLink(controller: 'product',action: 'list')}"> <img src="${resource(dir: 'images', file: 'basic-data-icon.png')}" alt="Calligo"/></br>Manage Products</li></a>
			</ul>
			</div>
			<div id= "status1">
				<ul>
				<li><a href="${createLink(controller: 'productPrices',action: 'list')}"> <img src="${resource(dir: 'images', file: 'Ecommerce-Price-tag-icon.png')}" alt="Calligo"/></br>Manage Product Prices</li></a>
				<li><a href="${createLink(controller: 'discount',action: 'list')}"> <img src="${resource(dir: 'images', file: 'discount-icon.png')}" alt="Calligo"/></br>Manage Discounts</li></a>
				<li><a href="${createLink(controller: 'contact',action: 'list')}"> <img src="${resource(dir: 'images', file: 'call-icon.png')}" alt="Calligo"/></br>Manage Contacts</li></a>
				<li><a href="${createLink(controller: 'contactType',action: 'list')}"> <img src="${resource(dir: 'images', file: 'question-type-drag-drop-icon.png')}" alt="Calligo"/></br>Manage Contact Types</li></a>
			</ul>
			</div>
			<div id= "status2">
				<ul>
				<li><a href="${createLink(controller: 'territory',action: 'list')}"> <img src="${resource(dir: 'images', file: 'earth-icon.png')}" alt="Calligo"/></br>Manage Territorys</li></a>
				<li><a href="${createLink(controller: 'invoice',action: 'list')}"> <img src="${resource(dir: 'images', file: 'MI-Scare-Report-icon.png')}" alt="Calligo"/></br>Reports</li></a>
				<li><a href="${createLink(controller: 'contact',action: 'list')}"> <img src="${resource(dir: 'images', file: 'support.png')}" alt="Calligo"/></br>Support</li></a>
				<li><a href="${createLinkTo(dir:"")}"><img src="${resource(dir: 'images', file: 'dashboard.png')}" alt="Calligo"/><br>Dashboard</li></a>

			</ul>
		</div>
		<div id="page-body" role="main">


<div class="mobselect">
	<select name ="menu" onChange="self.location.href=options[selectedIndex].value;"> 
    <option value="" selected="selected">Select</option> 
    
    <option value="${createLink(controller: 'role',action: 'list')}">Manage Roles </option> 
    <option value="${createLink(controller: 'user',action: 'list')}">Manage Users</option> 
    <option value="${createLink(controller: 'client',action: 'list')}">Manage Clients</option> 
    <option value="${createLink(controller: 'product',action: 'list')}">Manage Products</option> 
    <option value="${createLink(controller: 'productPrices',action: 'list')}">Manage Product Prices</option> 
    <option value="${createLink(controller: 'discount',action: 'list')}">Manage Discounts</option> 
    <option value="${createLink(controller: 'contact',action: 'list')}">Manage Contacts</option> 
    <option value="${createLink(controller: 'contactType',action: 'list')}">Manage Contact Types</option> 
    <option value="${createLink(controller: 'territory',action: 'list')}">Manage Territorys</option> 
    <option value="${createLink(controller: 'invoice',action: 'list')}">Reports</option> 
    <option value="${createLink(controller: 'contact',action: 'list')}">Support</option> 
    <option value="${createLinkTo(dir:"")}">Dashboard</option> 

  </select> 
  </div>





</div>


  </body>
</html>
			
		</div>
		</div>
	

	</body>
</html>
