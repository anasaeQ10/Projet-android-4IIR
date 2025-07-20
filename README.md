# 📱 Personal Expense Tracker App

Une application mobile simple et intuitive pour gérer vos finances personnelles. Suivez vos dépenses quotidiennes, catégorisez-les et définissez des budgets pour garder le contrôle de vos finances. L'application intègre l'authentification utilisateur via des appels API Volley et stocke les données localement à l'aide de Room Database.

---

## ✨ Fonctionnalités

- ➕ **Ajout de Dépenses**  
  Enregistrez les dépenses avec le montant, la description, la date et la catégorie.

- 📜 **Historique des Dépenses**  
  Consultez la liste complète de toutes vos dépenses passées.

- 🏷️ **Catégorisation**  
  Classez vos dépenses selon des catégories comme Nourriture, Transport, Divertissement, etc.

- 🎯 **Spécification de Budget**  
  Définissez des budgets mensuels pour surveiller et maîtriser vos habitudes de dépenses.

- 🔐 **Authentification Utilisateur**  
  Inscription et connexion via des requêtes API Volley connectées à un backend PHP + MySQL.

---

## 🛠️ Stack Technique

- **Plateforme :** Android (Java)  
- **Backend :** PHP + MySQL  
- **Réseau :** Volley (Appels API)  
- **Base de Données Locale :** Room  
- **Architecture :** MVVM

---

## 🗃️ Structure du Projet

- /model
- │ ├── Expense.java # Modèle de données pour une dépense
- │ ├── Category.java # Modèle de données pour une catégorie
- │ └── Wallet.java # (Optionnel) Modèle pour le solde du portefeuille

- /viewmodel
- │ └── ExpenseWithWalletAndCategory.java # Jointure des données dépense + portefeuille + catégorie

- /service
- │ ├── AuthServiceVolley.java # Gestion des requêtes API pour login/inscription
- │ ├── ExpenseService.java # Interface des fonctionnalités liées aux dépenses
- │ ├── CategoryService.java # Interface pour la gestion des catégories
- │ └── BudgetService.java # Interface pour la gestion du budget


---

## 🚀 Démarrage Rapide

### ✅ Prérequis

- Android Studio
- Serveur PHP + MySQL (ex. : XAMPP, WAMP, MAMP)
- Connexion Internet (pour les appels API)

### ⚙️ Étapes d'installation

1. **Cloner le dépôt :**

```bash
git clone https://github.com/your-username/expense-tracker-app.git


