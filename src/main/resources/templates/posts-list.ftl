<#import "parts/common.ftl" as c>

<@c.page>
<h2>Posts List</h2>
<#list posts as post>
<div>
    <b>ID: ${post.id}</b>
    <span> | ${post.description}</span>
    <span> | <b>Author: ${post.owner.name}</b></span>
</div>
<#else>
No posts
</#list>
</@c.page>