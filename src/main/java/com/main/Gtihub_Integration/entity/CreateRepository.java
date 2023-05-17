package com.main.Gtihub_Integration.entity;

public class CreateRepository {
    private int id;
    private String name;
    private String fullName;
    private boolean isPrivate;
    private Owner owner;
    private String htmlUrl;
    private String language;
    private boolean hasIssues;
    private boolean hasProjects;
    private boolean hasWiki;
    private int forksCount;
    private int openIssuesCount;

    // Constructors
    public CreateRepository() {
    }

    public CreateRepository(int id, String name, String fullName, boolean isPrivate, Owner owner, String htmlUrl,
                            String language, boolean hasIssues, boolean hasProjects, boolean hasWiki,
                            int forksCount, int openIssuesCount) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.isPrivate = isPrivate;
        this.owner = owner;
        this.htmlUrl = htmlUrl;
        this.language = language;
        this.hasIssues = hasIssues;
        this.hasProjects = hasProjects;
        this.hasWiki = hasWiki;
        this.forksCount = forksCount;
        this.openIssuesCount = openIssuesCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isHasIssues() {
        return hasIssues;
    }

    public void setHasIssues(boolean hasIssues) {
        this.hasIssues = hasIssues;
    }

    public boolean isHasProjects() {
        return hasProjects;
    }

    public void setHasProjects(boolean hasProjects) {
        this.hasProjects = hasProjects;
    }

    public boolean isHasWiki() {
        return hasWiki;
    }

    public void setHasWiki(boolean hasWiki) {
        this.hasWiki = hasWiki;
    }

    public int getForksCount() {
        return forksCount;
    }

    public void setForksCount(int forksCount) {
        this.forksCount = forksCount;
    }

    public int getOpenIssuesCount() {
        return openIssuesCount;
    }

    public void setOpenIssuesCount(int openIssuesCount) {
        this.openIssuesCount = openIssuesCount;
    }

    // Owner class
    public static class Owner {
        private String login;
        private int id;
        private String avatarUrl;
        private String url;

        public Owner(String login, int id, String avatarUrl, String url) {
            this.login = login;
            this.id = id;
            this.avatarUrl = avatarUrl;
            this.url = url;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
