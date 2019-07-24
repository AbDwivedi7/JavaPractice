<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>

	<form action="register" method="post" enctypm>
	
		Name: <input type="text" name="userName"/> <br/>
		Password: <input type="password" name="password"/> <br/>
		Email-ID: <input type="text" name="email"/><br/>
		Language: <select name="language">
					
					<option> Hindi </option>
					<option> English </option>
					<option> French</option>
					
				  </select><br/>
		Photo: <input type="file" name="pic" accept="image/*"><br/>
		<input type="submit" value="Submit"/>
		
	</form>

</body>
</html>