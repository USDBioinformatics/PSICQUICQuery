/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package psicquic;

/**
 *
 * @author Mathialakan
 */
public class URL {

    String psicquicurl = "psicquic-ws/webservices";;
    String version = "current";
    String query;
    String parameters ="";
    String method;
    String db;
    String dbURL;

    private enum Method {

        interactor, interaction, query, property, properties, formats, version
    };

    private enum Parameter {

        format, firstResult, maxResults, compressed
    }

    public URL(String db, String psicquicurl, String version, String query, String parameters, String method) {
        this.db = db;
        this.dbURL = this.dbURL(db);
        this.psicquicurl = psicquicurl;
        this.version = version;
        this.query = query;
        this.parameters = parameters;
        this.method = method;
    }

//    public URL(String db, String query, String parameters) {
//        this.method = Method.query.toString();
//        this.db = db;
//        this.dbURL = this.dbURL(db);
//        this.query = query;
//        this.parameters = parameters;
//    }

    public URL(String db, String method, String query, String parameters ) {
        this.query = query;
        this.parameters = parameters;
        this.method = method;
        this.db = db;
        this.dbURL = this.dbURL(db);
    }

    public URL(String db, String method, String query ) {
        this.query = query;
        this.method = method;
        this.db = db;
        this.dbURL = this.dbURL(db);
    }
    
    public String getPsicquicurl() {
        return psicquicurl;
    }

    public void setPsicquicurl(String psicquicurl) {
        this.psicquicurl = psicquicurl;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String generate() {
        return this.dbURL+this.psicquicurl + "/" + this.version + "/search/" + this.method + "/" + this.query + ((this.parameters.equals("")) ? "" : "?" + this.parameters);
    }

    private String dbURL(String db) {
        switch (db) {
            case "APID":
                return "http://cicblade.dep.usal.es/";
            case "BioGrid":
                return "http://tyersrest.tyerslab.com:8805";
            case "BIND":
                return "http://webservice.baderlab.org:8480/";
            case "BindingDB":
                return "http://catalyst.ucsd.edu:8080/";
            case "BAR":
                return "http://bar.utoronto.ca:9090/";
            case "DIP":
                return "http://imex.mbi.ucla.edu/";
            case "DrugBank":
                return "http://psicquic.wishartlab.com/";
            case "GeneMANIA":
                return "http://webservice.baderlab.org:8380/";
            case "InnateDB":
                return "http://psicquic.curated.innatedb.com/";
            case "Interproc":
                return "http://webservice.baderlab.org:8580/";
            case "I2D":
                return "http://ophid.utoronto.ca/";
            case "IntAct":
                //return "http://www.ebi.ac.uk/Tools/";
            case "HPIDb":
                //return " http://www.ebi.ac.uk/Tools/";
            case "ChEMBL":
                //return "http://www.ebi.ac.uk/Tools/";
            case "I2D-IMEx":
                //return "http://www.ebi.ac.uk/Tools/";
            case "InnateDB-IMEx":
                // return "http://www.ebi.ac.uk/Tools/";
            case "MPIDB":
                //return "http://www.ebi.ac.uk/Tools/";
            case "MLolCon":
                //return "http://www.ebi.ac.uk/Tools/";
            case "MBInfo":
                //return "http://www.ebi.ac.uk/Tools/";
            case "Reactome":
                //return "http://www.ebi.ac.uk/Tools/";
            case "Reactome-FIs":
                // return "http://www.ebi.ac.uk/Tools/";
            case "UniProt":
                //return "http://www.ebi.ac.uk/Tools/";
            case "bhf-ucl":
                return "http://www.ebi.ac.uk/Tools/";
            case "MatrixDB":
                return "http://matrixdb.ibcp.fr:8080/";
            case "MINT":
                return "http://ophid.utoronto.ca/";
            case "STRING":
                return "http://string.uzh.ch/";
            case "Spike":
                return "http://spike.cs.tau.ac.il/";
            case "TopFind":
                return "http://clipserve.clip.ubc.ca/";
            case "VirHostNet":
                return "http://pbildb1.univ-lyon1.fr:8080/";
            case "iRefIndex":
                return "http://psicquic.irefindex.org/";
            case "mentha":
                return "http://mentha.uniroma2.it:9090/";
            default: return "";
        }
    }
}
