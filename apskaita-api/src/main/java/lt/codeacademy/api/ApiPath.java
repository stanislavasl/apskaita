package lt.codeacademy.api;

public interface ApiPath {
    String ID_VARIABLE = "id";
    String NAME_VARIABLE = "name";

    String ENTRIES = "/entries";
    String ACCOUNTS = "/accounts";
    String CLIENTS = "/clients";
    String SEARCH = "/search";

    String ACCOUNT = "/{" + ID_VARIABLE + "}";
    String CLIENT= "/{" + ID_VARIABLE + "}";
    String ENTRY = "/{" + ID_VARIABLE + "}";
}
