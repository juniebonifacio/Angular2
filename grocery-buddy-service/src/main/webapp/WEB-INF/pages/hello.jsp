<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Hello World</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/es6-shim/0.33.3/es6-shim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/systemjs/0.19.20/system-polyfills.js"></script>
<script src="https://code.angularjs.org/2.0.0-beta.6/angular2-polyfills.js"></script>
<script src="https://code.angularjs.org/tools/system.js"></script>
<script src="https://code.angularjs.org/tools/typescript.js"></script>
<script src="https://code.angularjs.org/2.0.0-beta.6/Rx.js"></script>
<script src="https://code.angularjs.org/2.0.0-beta.6/angular2.dev.js"></script>
    <script>
      System.config({
        transpiler: 'typescript',
        typescriptOptions: { emitDecoratorMetadata: true },
        packages: {'app': {defaultExtension: 'ts'}},
        map: { 'app': './angular2/src/app' }
      });
      System.import('pages/environment_main')
            .then(null, console.error.bind(console));
    </script>
<style type="text/css">
table {
	border: 1px solid black;
}

th,td {
	padding: 15px;
	border: 1px solid gray;
}

th {
	text-align: center;
}
</style>
</head>
<body>
	<my-app>Loading...</my-app>
	<h2>${message}</h2>
	<table>
		<tr>
			<th colspan="3">User List</th>
		</tr>
		<tr>
			<th>User Name</th>
			<th>Role</th>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td><c:out value="${user.name} " /></td>
				<td><c:out value="${user.role} " /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>