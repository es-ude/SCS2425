rootProject.name = "SoftwareCraftsmanshipWS2425"
include("src:main:tutorium")
findProject(":src:main:tutorium")?.name = "tutorium"
include("exercicse")
include("src:exercise")
findProject(":src:exercise")?.name = "exercise"
include("exercise")
