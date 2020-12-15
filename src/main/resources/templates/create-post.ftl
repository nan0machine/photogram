<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div>
    <@l.logout />
</div>
<h2>Create a new Post</h2>
<form action="/post/create" method="post" enctype="multipart/form-data">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Description : </label>
        <div class="col-sm-6">
            <input type="text" name="description" class="form-control" placeholder="Enter a description"/>
        </div>
    </div>
    <input type="file" name="file"/>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div>
        <button type="submit" class="btn btn-primary">Create post</button>
    </div>
</form>
</@c.page>