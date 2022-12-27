enum LineType {
    NUMBER,
    NAME,
    INSTRUCTOR,
    STAFF,
    UNDERGRADUATE,
    GRADUATE,
    INVALID
}

public class Parser {
    //instance variables that hold data for the CourseReport to
    private String number;
    private String name;
    private Faculty instructor;
    private Staff teachingAssistant;
    private Undergraduate undergraduate;
    private Graduate graduate;
    public Parser() {}
    public LineType parseLine(String[] line) {
        // takes a line as a String array as input
        // returns type of line based on identifier of line (Instructor, Graduate, etc.)
        // Makes a call to a parsing function for the specific line, updates corresponding instance variable
        // CourseReport makes a call to get the info at the updated variable
        String f = line[0].split(":", 0)[0].trim();
        if (f.equals("Number")) {
            parseNumber(line);
            return LineType.NUMBER;
        }
        else if (f.equals("Name")) {
            parseName(line);
            return LineType.NAME;
        }
        else if (f.equals("Instructor")) {
            parseInstructor(line);
            return LineType.INSTRUCTOR;
        }
        else if (f.equals("Staff")) {
            parseStaff(line);
            return LineType.STAFF;
        }
        else if (f.equals("Undergraduate")) {
            parseUndergrad(line);
            return LineType.UNDERGRADUATE;
        }
        else if (f.equals("Graduate")) {
            parseGrad(line);
            return LineType.GRADUATE;
        }
        return LineType.INVALID;
    }

    // parser functions to parse a given line (which is sent as input based on a String array)
    private void parseNumber(String[] line) {
        number = line[0].split(":", 0)[1].trim();
    }
    private void parseName(String[] line) {
        name = line[0].split(":", 0)[1].trim();
    }
    private void parseInstructor(String[] line) {
        String curName = getName(line);
        String curID = getID(line);
        double curSal = getSal(line);
        int curHireDate = getStart(line);
        String curTitle = line[4].trim();
        instructor = new Faculty(curName, curSal, curHireDate, curID, curTitle);
    }
    private void parseStaff(String[] line) {
        String curName = getName(line);
        String curID = getID(line);
        double curSal = getSal(line);
        int curHireDate = getStart(line);
        int curPayGrade = Integer.parseInt(line[4].trim());
        teachingAssistant = new Staff(curName, curSal, curHireDate, curID, curPayGrade);
    }
    private void parseUndergrad(String[] line) {
        String curName = getName(line);
        int curNum = getStudentNum(line);
        String tempGrade = line[2].trim();
        Grade curGrade;
        if (tempGrade.equals("FRESHMAN")) {
            curGrade = Grade.FRESHMAN;
        }
        else if (tempGrade.equals("SOPHOMORE")) {
            curGrade = Grade.SOPHOMORE;
        }
        else if (tempGrade.equals("JUNIOR")) {
            curGrade = Grade.JUNIOR;
        } else {
            curGrade = Grade.SENIOR;
        }
        undergraduate = new Undergraduate(curName, curNum, curGrade);
    }
    private void parseGrad(String[] line) {
        String curName = getName(line);
        int curNum = getStudentNum(line);
        String tempProgram = line[2].trim();
        GraduateProgram curProgram;
        if (tempProgram.equals("MASTERS")) {
            curProgram = GraduateProgram.MASTERS;
        }
        else {
            curProgram = GraduateProgram.DOCTORAL;
        }
        graduate = new Graduate(curName, curNum, curProgram);
    }

    // accessor functions for instance variables
    public String getNumber() { return number; }
    public String getName() { return name; }
    public Faculty getInstructor() { return instructor; }
    public Staff getTeachingAssistant() { return teachingAssistant; }
    public Undergraduate getUndergraduate() { return undergraduate; }
    public Graduate getGraduate() { return graduate; }


    // parsing helper functions --> functionality that multiple types of lines need when parsing
    private String getName(String[] line) {
        String[] tempName = line[0].split(":", 0)[1].split(",");
        return tempName[1].trim() + " " + tempName[0].trim();
    }
    private String getID(String[] line) {
        return line[1].trim();
    }
    private double getSal(String[] line) {
        return Double.parseDouble(line[2].replaceAll(",", "").trim());
    }
    private int getStart(String[] line) {
        return Integer.parseInt(line[3].trim());
    }
    private int getStudentNum(String[] line) {
        return Integer.parseInt(line[1].trim());
    }
}
