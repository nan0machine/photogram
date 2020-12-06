<#import "parts/common.ftl" as c>

<@c.page>
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