console.log("here");
console.error("booboo");
var buildUI = function() {
    console.log("YEE AAA");
    console.log("YEE AAA2");

    console.log("setting x");
    EBUIBuilder.x = 123;
    console.log("x is set");

    templateSV = {
        tabName: "Templates",
        tableView: {title: "Templates",   data: templates,   cellFieldName: "TemplateName",  buttons:"Edit, +"},
        formView:  {title: "Template details", xml: "TemplateForm", buttons: ",Edit"}
    };

    console.log("YEE AAAP");
    projectSV = {
        tabName: "Projects",
        tableView: {title: "Projects",   data: projects,     cellFieldName: "ProjectName",   buttons:"Edit, +"},
        formView:  {title: "Project details",  xml: "MTEProjectForm", buttons: ",Edit"}
    };

    console.log("YEE AAAI");
    inspectionSV = {
        tabName: "Inspections",
        tableView: {title: "Inspections", data: inspections, cellFieldName: "InspectionNumber", buttons:"Edit, +"},
        formView:  {title: "Inspection details",  xml: "InspectionForm", buttons: ",Edit"}
    };

    console.log("YEE AAps");
    photoSV = {
        tabName: "Photos",
        tableView: {title: "Photos",      data: photos,      cellFieldName: "PhotoNumber",    buttons:"Edit, +"},
        formView:  {title: "Photo details",    xml: "PhotoForm", buttons: ",Edit"}
    };


    var obj = [templateSV, projectSV, inspectionSV, photoSV];
    activeTabName = "Templates";

    EBUIBuilder.buildUI(obj);
};
