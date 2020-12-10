<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div>
    <@l.logout />
</div>
<#list posts as post>
<div>
    <b>${post.id}</b>
    <span>${post.description}</span>
    <img src="/img/${post.photoName}">
</div>
<#else>
    No posts
</#list>
</@c.page>