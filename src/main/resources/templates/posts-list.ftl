<#import "parts/common.ftl" as c>

<@c.page>
<h2>Posts List</h2>
<div class="card-columns">
<#list posts as post>
    <div class="card">
        <img class="card-img-top" src="/img/${post.photoName}" alt="image">
        <div class="card-body">
            <h5 class="card-title">${post.description}</h5>
            <p class="card-text">Author: ${post.owner.name}</p>
        </div>
    </div>
<#else>
No posts
</#list>
</div>
</@c.page>