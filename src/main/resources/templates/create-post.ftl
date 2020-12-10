<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div>
    <@l.logout />
</div>
<h2>Create a new Post</h2>
<form action="/post/create" method="post" enctype="multipart/form-data">
    <div><label> Description : <input type="text" name="description" placeholder="Enter a description"/> </label></div>
    <input type="file" name="file"/>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div><input type="submit" value="Create"/></div>
</form>
</@c.page>