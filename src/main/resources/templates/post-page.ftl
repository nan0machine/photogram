<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div>
    <@l.logout />
</div>
<h2>${post.id} Post</h2>
<#list post.photos as photo>
    <img src="/img/${photo.uri}">
</#list>
<div><b>${post.description}</b></div>
</@c.page>