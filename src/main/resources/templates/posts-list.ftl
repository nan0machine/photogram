<#import "parts/common.ftl" as c>

<@c.page>
<h2>Posts List</h2>
<#list posts as post>
<div>
    <b>ID: ${post.id}</b>
    <span> | ${post.description}</span>
</div>
<#else>
No posts
</#list>
</@c.page>