<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div>
    <@l.logout />
</div>
<h2>Update ${user.name}'s Page</h2>
<form action="/user/${user.id}/update" method="post">
    <div><label> User Id : <input type="text" name="userId" value="${user.id}" readonly/> </label></div>
    <div><label> User Name : <input type="text" name="username" value="${user.name}"/> </label></div>
    <div><label> Email : <input type="text" name="email" value="${user.email}"/> </label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div><input type="submit" value="Update"/></div>
</form>
</div>
</@c.page>