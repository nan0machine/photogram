<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div>
    <@l.logout />
</div>
<h2>Update ${post.owner.name}'s Post</h2>
<form action="/post/${post.id}/update/user/${post.owner.id}" method="post">
    <input type="hidden" name="postId" value="${post.id}" />
    <div> Photo : </div>
    <div>
    <#list post.photos as photo>
        <img src="/img/${photo.uri}">
    </#list>
    </div>
    <div><label> Description : <input type="text" name="description" value="${post.description}"/> </label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div><input type="submit" value="Update"/></div>
</form>
</div>
</@c.page>