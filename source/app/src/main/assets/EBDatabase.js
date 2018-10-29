

var templatesTable =
    {
        name: "Projects",
        rows:
            [
             {id:"1", TemplateName: "Audit Report"},
             {id:"2", TemplateName: "Condition Assessment"}
            ],
        selected: 2,
        parentTable: "",
        childTable: "Projects",
        sort: "TemplateName"
    };
var templates = dbQuery({table: templatesTable});
var template = templates[0];

var projectsTable =
    {
        name: "Projects",
        rows:
            [
             {id:"1", parent:"1", ProjectName:"Audit 1", ClientName:"ABC Corp", City:"Toronto"},
             {id:"2", parent:"1", ProjectName:"Audit 2", ClientName:"DEF Corp", City:"Toronto"},
             {id:"3", parent:"2", ProjectName:"Condition Assessment 1", ClientName:"AAA Corp", City:"Toronto"}
            ],
        selected: 2,
        parentTable: "Templates",
        childTable: "Inspections",
        sort: "ProjectName"
    };
var projects = dbQuery({table: projectsTable});
var project = projects[0];


var inspectionsTable =
    {
        name: "Inspections",
        rows:
            [
             {id:"1", parent:"1", InspectionNumber:"Audit 1 - Ins 1", InspectionDate:"Sept 1, 2018", Inspector:"Joe"},
             {id:"2", parent:"1", InspectionNumber:"Audit 1 - Ins 2", InspectionDate:"Sept 2, 2018", Inspector:"Joe"},
             {id:"3", parent:"1", InspectionNumber:"Audit 1 - Ins 3", InspectionDate:"Sept 3, 2018", Inspector:"Joe"},
             {id:"4", parent:"1", InspectionNumber:"Audit 1 - Ins 4", InspectionDate:"Sept 1, 2018", Inspector:"Joe"},
             {id:"5", parent:"2", InspectionNumber:"Audit 2 - Ins 1", InspectionDate:"Sept 2, 2018", Inspector:"Joe"},
             {id:"6", parent:"2", InspectionNumber:"Audit 2 - Ins 2", InspectionDate:"Sept 2, 2018", Inspector:"Joe"}
            ],
        selected: 2,
        parentTable: "Projects",
        childTable: "Photos",
        sort: "InspectionNumber"
    };
var inspections = dbQuery({table: inspectionsTable});
var inspection = inspections[0];


var photosTable =
    {
        name: "Photos",
        rows:
            [
             {id:"1", parent:"1", PhotoNumber:"1", FileName:"EBSI00001.jpg"},
             {id:"2", parent:"1", PhotoNumber:"2", FileName:"EBSI00002.jpg"},
             {id:"3", parent:"1", PhotoNumber:"3", FileName:"EBSI00003.jpg"},
             {id:"4", parent:"1", PhotoNumber:"4", FileName:"EBSI00004.jpg"},
             {id:"5", parent:"1", PhotoNumber:"5", FileName:"EBSI00005.jpg"},
             {id:"6", parent:"2", PhotoNumber:"6", FileName:"EBSI00006.jpg"},
             {id:"7", parent:"2", PhotoNumber:"7", FileName:"EBSI00007.jpg"},
             {id:"8", parent:"2", PhotoNumber:"8", FileName:"EBSI00008.jpg"}
            ],
        selected: 2,
        parentTable: "Inspections",
        childTable: "",
        sort: "PhotoNumber"
    };
var photos = dbQuery({table: photosTable});
var photo = photos[0];


var settingsTable =
    {
        name: "Photos",
        rows:
            [
             {id:"1", parent:"1", SettingsName:"Device"},
             {id:"2", parent:"1", SettingsName:"User"},
             {id:"3", parent:"1", SettingsName:"Photos"},
             {id:"4", parent:"1", SettingsName:"E-Mail"},
             {id:"5", parent:"1", SettingsName:"About"}
            ],
        selected: 2,
        parentTable: "",
        childTable: "",
        sort: ""
    };
var settings = dbQuery({table: settingsTable});
var setting = settings[0];


var formTestsTable =
    {
        name: "FormTests",
        rows:
            [
             {id:"1", TestName:"DictionaryValidations"},
             {id:"2", TestName:"DirectiveValidations"},
             {id:"3", TestName:"DrawLabel_Basics"},
             {id:"4", TestName:"DrawLabel_Styles"},
             {id:"5", TestName:"DrawLabel_Fonts"},
             {id:"6", TestName:"DrawLabel_Colors"},
             {id:"7", TestName:"DrawTextBox"},
             {id:"8", TestName:"DrawCheckBox"},
             {id:"9", TestName:"DrawMemoControl"}
            ],
        selected: 2,
        parentTable: "",
        childTable: "",
        sort: ""
    };
var formTests = dbQuery({table: formTestsTable});
var formTest = formTests[0];


var reportTestsTable =
    {
        name: "FormTests",
        rows:
            [
             {id:"1", TestName:"DrawText"},
             {id:"2", TestName:"DrawText_Fonts"},
             {id:"3", TestName:"DrawText_Colors"},
             {id:"4", TestName:"DrawMemo"},
             {id:"5", TestName:"DrawLine"},
             {id:"6", TestName:"DrawBox"}
            ],
        selected: 2,
        parentTable: "",
        childTable: "",
        sort: ""
    };
var reportTests = dbQuery({table: reportTestsTable});
var reportTest = reportTests[0];
