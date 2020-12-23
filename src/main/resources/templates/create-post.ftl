<#import "parts/common.ftl" as c>

<@c.page>
<h2>Create a new post</h2>
<form action="/post/create" method="post" enctype="multipart/form-data">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Description : </label>
        <div class="col-sm-6">
            <input type="text" name="description" class="form-control" placeholder="Enter a description"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Photo : </label>
        <div class="col-sm-6">
            <input type="file"
                   class="form-control ${(fileInvalid??)?string('is-invalid','')}"
                   name="file"/>
            <#if fileInvalid??>
                <div class="invalid-feedback">
                    ${fileInvalid}
                </div>
            </#if>
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div>
        <button type="submit" class="btn btn-primary">Create post</button>
    </div>
</form>
</@c.page>