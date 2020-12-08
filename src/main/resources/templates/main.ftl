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
    <#list post.photos as photo>
        <img src="/img/${photo.uri}">
    </#list>
</div>
<#else>
    No posts
</#list>
</@c.page>