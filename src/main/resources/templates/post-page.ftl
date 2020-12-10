<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div>
    <@l.logout />
</div>
<h2>${post.id} Post</h2>
<img src="/img/${post.photoName}">
<div><b>${post.description}</b></div>
</@c.page>