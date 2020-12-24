<#import "parts/common.ftl" as c>

<@c.page>
<h2>Edit info</h2>
<form action="/post/${post.id}/update" method="post">
    <input type="hidden" name="post" value="${post.id}" />
    <div> Photo : </div>
    <div class="mb-4">
        <img src="/img/${post.photoName}"
             alt="photo"
             class="rounded"
             style="max-width: 55%; height: auto;">
    </div>
    <div><label> Description : <input type="text" name="description" value="${post.description}"/> </label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div><input type="submit" value="Update"/></div>
</form>
</div>
</@c.page>