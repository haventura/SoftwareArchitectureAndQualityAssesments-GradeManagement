# SoftwareArchitectureAndQualityAssesments-GradeManagement

##One Note questions
Définir notes
	- Résultats de l'ue numérique
Définir  grades
	- Distinction, etc (système de conditions pour obtenir un grade) le grade peut être discuté par délibération
Langue cible du projet
	- english
Propre repo GitHub ou commun?
	- Chaque micro service dispose de son propre repo
Quelle équipe doit nous envoyer les infos sur les notes et grades
	- À voir durant la 2e séance, chaque "chef" de grp discutera
Limitations base de données
	- Chaque micro service gère sa base de données
Localisation de la base de données (serveurs de l'ecam ?)
	- Accès à des containers sur une machine virtuelle des serveurs ECAM, choix à faire lors de la prochaine séance

##Data model
	- Student ID
	- UE ID
	- Courses ID
	- Grades
	- UE grade = average of the whole courses grades contained in an UE
	- Total grade = average of whole uear grades
	- Grades conversion--> numbers to letter (A, B, C, …)
	- Management of constraints over grades
	- Grades modified by "jury" if available!
