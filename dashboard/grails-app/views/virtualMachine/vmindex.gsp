<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Calligo Dashboard</title>
		<style type="text/css" media="screen">
			#status {
				background-color: transparent;
				border: .0em solid #fff;
				margin: 11em 25em 1em;
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
				#status {
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
		<div id="status" >
			<h1>Administration Tasks:</h1>
			<dl>
				<dt><a href="${createLink(controller: 'virtualMachine',action: 'index')}"> <img src="${resource(dir: 'images', file: 'Devices-computer-icon.png')}" alt="Calligo"/> </dt><dd>Compute</dd></a>
				<dt><a href="${createLink(controller: 'virtualMachine',action: 'index')}"> <img src="${resource(dir: 'images', file: 'basic-data-icon.png')}" alt="Calligo"/><dt><dd>Storage</dd></a>
				<dt><a href="${createLink(controller: 'serviceMonitor',action: 'list')}"> <img src="${resource(dir: 'images', file: 'network-icon.png')}" alt="Calligo"/></dt><dd>Networking</dd></a>
			</dl>
		</div>
		<div id="page-body" role="main">


<div class="mobselect">
	<select name ="menu" onChange="self.location.href=options[selectedIndex].value;"> 
    <option value="" selected="selected">Select</option> 
    
    <option value="${createLink(controller: 'item',action: 'list')}">Compute </option> 
    <option value="${createLink(controller: 'virtualMachine',action: 'index')}">Storage</option>!
    <option value="${createLink(controller: 'serviceMonitor',action: 'list')}">Networking</option> 


  </select> 
  </div>




</div>


  </body>
</html>
			
		</div>
		</div>
	

	</body>
</html>
