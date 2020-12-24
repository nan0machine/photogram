<#import "parts/common.ftl" as c>

<@c.page>
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