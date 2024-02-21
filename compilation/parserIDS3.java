
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class parserIDS3 {

    public String[] LRGS = {
    		
            "Program->Declar ListInst",
            "Declar->Affect ; Declar",
            "Declar->epsilon",
            "Affect->Type dp id",
            "Type->entier",
            "Type->reel",
            "Type->booleen",
            "Type->tableau [ nb ] de Type",
            "ListInst->Inst ListInst",
            "ListInst->epsilon",
            "Inst->debut ListInst fin",
            "Inst->id := Exp ;",
            "Inst->si Exp alors ListInst sinon ListInst finsi",
            "Inst->pour Exo faire ListInst finpour",
            "Inst->lire Exp ;",
            "Inst->afficher Exp ;",
            "Exp->nb",
            "Exp->id",
            "Exp->( Exp )",
            "Exp->[ Exp ]",
            "Exp->id opprel id",
            "Exp->nb opprel nb",
            "Exp->id opp id",
            "Exp->nb opp nb",
            "Exp->true",
            "Exp->false",
            "Exp->litteral",
    };

    public String[][] tableSLR = {
            { "etat/VT", ";", ":", "id", "entier", "reel", "booleen", "tableau", "[", "nb", "]",
                    "de", "debut", "fin", ":=", "si", "alors", "sinon", "finsi", "pour",
                    "faire", "finpour", "lire", "afficher", "(", ")", "opprel", "opp",
                    "true", "false", "litteral", "$", "Program", "Declar", "Affect", "Type", "ListInst", "Inst", "Exp" },
            { "0", "err", "err", "r3", "s5", "s6", "s7", "s8", "err", "err", "err", "err", "r3", "err",
                        "err", "r3",
                        "err", "err", "err", "r3", "err", "err", "r3", "r3", "err", "err", "err", "err",
                        "err", "err",
                        "err", "r3", "1", "2", "3", "4", "err", "err", "err" },
                { "1", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                        "err",
                        "err", "err",
                        "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                        "err", "err", "err",
                        "err", "ACC", "err", "err", "err", "err", "err", "err", "err" },
                { "2", "err", "err", "s12", "err", "err", "err", "err", "err", "err", "err", "err", "s11",
                        "r10", "err",
                        "s13", "err", "r10", "r10", "s14", "err", "r10", "s15", "s16", "err", "err",
                        "err", "err", "err",
                        "err", "err", "r10", "err", "err", "err", "err", "9", "10", "err" },
            { "3", "s17", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err" },
            { "4", "err", "s18", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err" },
            { "5", "err", "r5", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err" },
            { "6", "err", "r6", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err" },
            { "7", "err", "r7", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err" },
            { "8", "err", "err", "err", "err", "err", "err", "err", "s19", "err", "err", "err", "err",
                    "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err" },
            { "9", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err",
                    "err", "err", "r1", "err", "err", "err", "err", "err", "err", "err" },
            { "10", "err", "err", "s12", "err", "err", "err", "err", "err", "err", "err", "err", "s11",
                    "r10", "err",
                    "s13", "err", "r10", "r10", "s14", "err", "r10", "s15", "s16", "err", "err",
                    "err", "err", "err",
                    "err", "err", "r10", "err", "err", "err", "err", "20", "10", "err" },
            { "11", "err", "err", "s12", "err", "err", "err", "err", "err", "err", "err", "err", "s11",
                    "r10", "err",
                    "s13", "err", "r10", "r10", "s14", "err", "r10", "s15", "s16", "err", "err",
                    "err", "err", "err",
                    "err", "err", "r10", "err", "err", "err", "err", "21", "10", "err" },
            { "12", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "s22",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err" },
            { "13", "err", "err", "s25", "err", "err", "err", "err", "s27", "s24", "err", "err", "err",
                    "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "s26", "err",
                    "err", "err", "s28",
                    "s29", "s30", "err", "err", "err", "err", "err", "err", "err", "23" },
            { "14", "err", "err", "s25", "err", "err", "err", "err", "s27", "s24", "err", "err", "err",
                    "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "s26", "err",
                    "err", "err", "s28",
                    "s29", "s30", "err", "err", "err", "err", "err", "err", "err", "31" },
            { "15", "err", "err", "s25", "err", "err", "err", "err", "s27", "s24", "err", "err", "err",
                    "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "s26", "err",
                    "err", "err", "s28",
                    "s29", "s30", "err", "err", "err", "err", "err", "err", "err", "32" },
            { "16", "err", "err", "s25", "err", "err", "err", "err", "s27", "s24", "err", "err", "err",
                    "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "s26", "err",
                    "err", "err", "s28",
                    "s29", "s30", "err", "err", "err", "err", "err", "err", "err", "33" },
            { "17", "err", "err", "r3", "s5", "s6", "s7", "s8", "err", "err", "err", "err", "r3", "err",
                    "err", "r3", "err", "err", "err", "r3", "err", "err", "r3", "r3", "err", "err",
                    "err", "err", "err", "err", "err", "r3", "err", "34", "3", "4", "err", "err",
                    "err" },
            { "18", "err", "err", "s35", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "19", "err", "err", "err", "err", "err", "err", "err", "err", "s36", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "20", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "r9", "err", "err", "err", "r9", "r9", "err", "err", "r9", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "r9", "err", "err", "err", "err",
                    "err", "err", "err" },
            { "21", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "s37", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "22", "err", "err", "s25", "err", "err", "err", "err", "s27", "s24", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "s26", "err", "err", "err", "s28", "s29", "s30", "err", "err", "err", "err",
                    "err", "err", "err", "38" },
            { "23", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "s39", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "24", "r17", "err", "err", "err", "err", "err", "err", "err", "err", "r17", "err", "err",
                    "err", "err", "err", "r17", "err", "err", "err", "r17", "err", "err", "err",
                    "err", "r17", "s40", "s41", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "25", "r18", "err", "err", "err", "err", "err", "err", "err", "err", "r18", "err", "err",
                    "err", "err", "err", "r18", "err", "err", "err", "r18", "err", "err", "err",
                    "err", "r18", "s42", "s43", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "26", "err", "err", "s25", "err", "err", "err", "err", "s27", "s24", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "s26", "err", "err", "err", "s28", "s29", "s30", "err", "err", "err", "err",
                    "err", "err", "err", "44" },
            { "27", "err", "err", "s25", "err", "err", "err", "err", "s27", "s24", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "s26", "err", "err", "err", "s28", "s29", "s30", "err", "err", "err", "err",
                    "err", "err", "err", "45" },
            { "28", "r25", "err", "err", "err", "err", "err", "err", "err", "err", "r25", "err", "err",
                    "err", "err", "err", "r25", "err", "err", "err", "r25", "err", "err", "err",
                    "err", "r25", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "29", "r26", "err", "err", "err", "err", "err", "err", "err", "err", "r26", "err", "err",
                    "err", "err", "err", "r26", "err", "err", "err", "r26", "err", "err", "err",
                    "err", "r26", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "30", "r27", "err", "err", "err", "err", "err", "err", "err", "err", "r27", "err", "err",
                    "err", "err", "err", "r27", "err", "err", "err", "r27", "err", "err", "err",
                    "err", "r27", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "31", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "s46", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "32", "s47", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "33", "s48", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "34", "err", "err", "r2", "err", "err", "err", "err", "err", "err", "err", "err", "r2", "err",
                    "err", "r2", "err", "err", "err", "r2", "err", "err", "r2", "r2", "err", "err",
                    "err", "err", "err", "err", "err", "r2", "err", "err", "err", "err", "err",
                    "err", "err" },
            { "35", "r4", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "36", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s49", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "37", "err", "err", "r11", "err", "err", "err", "err", "err", "err", "err", "err", "r11",
                    "r11", "err", "r11", "err", "r11", "r11", "r11", "err", "r11", "r11", "r11",
                    "err", "err", "err", "err", "err", "err", "err", "r11", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "38", "s50", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "39", "err", "err", "s12", "err", "err", "err", "err", "err", "err", "err", "err", "s11",
                    "r10", "err", "s13", "err", "r10", "r10", "s14", "err", "r10", "s15", "s16",
                    "err", "err", "err", "err", "err", "err", "err", "r10", "err", "err", "err",
                    "err", "51", "10", "err" },
            { "40", "err", "err", "err", "err", "err", "err", "err", "err", "s52", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "41", "err", "err", "err", "err", "err", "err", "err", "err", "s53", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "42", "err", "err", "s54", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "43", "err", "err", "s55", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "44", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "s56", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "45", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s57", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "46", "err", "err", "s12", "err", "err", "err", "err", "err", "err", "err", "err", "s11",
                    "r10", "err", "s13", "err", "r10", "r10", "s14", "err", "r10", "s15", "s16",
                    "err", "err", "err", "err", "err", "err", "err", "r10", "err", "err", "err",
                    "err", "58", "10", "err" },
            { "47", "err", "err", "r15", "err", "err", "err", "err", "err", "err", "err", "err", "r15",
                    "r15", "err", "r15", "err", "r15", "r15", "r15", "err", "r15", "r15", "r15",
                    "err", "err", "err", "err", "err", "err", "err", "r15", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "48", "err", "err", "r16", "err", "err", "err", "err", "err", "err", "err", "err", "r16",
                    "r16", "err", "r16", "err", "r16", "r16", "r16", "err", "r16", "r16", "r16",
                    "err", "err", "err", "err", "err", "err", "err", "r16", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "49", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s59", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "50", "err", "err", "r12", "err", "err", "err", "err", "err", "err", "err", "err", "r12",
                    "r12", "err", "r12", "err", "r12", "r12", "r12", "err", "r12", "r12", "r12",
                    "err", "err", "err", "err", "err", "err", "err", "r12", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "51", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "s60", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "52", "r22", "err", "err", "err", "err", "err", "err", "err", "err", "r22", "err", "err",
                    "err", "err", "err", "r22", "err", "err", "err", "r22", "err", "err", "err",
                    "err", "r22", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "53", "r24", "err", "err", "err", "err", "err", "err", "err", "err", "r24", "err", "err",
                    "err", "err", "err", "r24", "err", "err", "err", "r24", "err", "err", "err",
                    "err", "r24", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "54", "r21", "err", "err", "err", "err", "err", "err", "err", "err", "r21", "err", "err",
                    "err", "err", "err", "r21", "err", "err", "err", "r21", "err", "err", "err",
                    "err", "r21", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "55", "r23", "err", "err", "err", "err", "err", "err", "err", "err", "r23", "err", "err",
                    "err", "err", "err", "r23", "err", "err", "err", "r23", "err", "err", "err",
                    "err", "r23", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "56", "r19", "err", "err", "err", "err", "err", "err", "err", "err", "r19", "err", "err",
                    "err", "err", "err", "r19", "err", "err", "err", "r19", "err", "err", "err",
                    "err", "r19", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "57", "r20", "err", "err", "err", "err", "err", "err", "err", "err", "r20", "err", "err",
                    "err", "err", "err", "r20", "err", "err", "err", "r20", "err", "err", "err",
                    "err", "r20", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "58", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "s61", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "59", "err", "err", "err", "s5", "s6", "s7", "s8", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "62",
                    "err", "err", "err" },
            { "60", "err", "err", "s12", "err", "err", "err", "err", "err", "err", "err", "err", "s11",
                    "r10", "err", "s13", "err", "r10", "r10", "s14", "err", "r10", "s15", "s16",
                    "err", "err", "err", "err", "err", "err", "err", "r10", "err", "err", "err",
                    "err", "63", "10", "err" },
            { "61", "err", "err", "r14", "err", "err", "err", "err", "err", "err", "err", "err", "r14",
                    "r14", "err", "r14", "err", "r14", "r14", "r14", "err", "r14", "r14", "r14",
                    "err", "err", "err", "err", "err", "err", "err", "r14", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "62", "err", "r8", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "63", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "err", "s64", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err",
                    "err", "err", "err", "err" },
            { "64", "err", "err", "r13", "err", "err", "err", "err", "err", "err", "err", "err", "r13",
                    "r13", "err", "r13", "err", "r13", "r13", "r13", "err", "r13", "r13", "r13",
                    "err", "err", "err", "err", "err", "err", "err", "r13", "err", "err", "err",
                    "err", "err", "err", "err" }, };

    public Stack<String> stackState = new Stack<>();

    public Stack<String> analyse = new Stack<>();

    public Stack<String> stackSymbol = new Stack<>();

    String ch[] = { "entier", ":", "id", ";", "id",":=","nb",";","$" };
    public String strInput;

    public String action ="";

    int index = 0;

    public void analyzeSLnew() {

        action ="";
        index =0;

        analyse.push("0");


        System.out.println(" ******** pile                                                               Entrée                                                            Action	********		   ");
        this.AfficherSLR();
        while(index<ch.length)

        {

            String s = analyse.peek();

            //String act=Action(s,ch[index]);

            if (Action(s,ch[index]).charAt(0) == 's') {
                System.out.println("** Decalage ***");

                analyse.push(ch[index]);
                analyse.push(Action(s, ch[index]).substring(1));

                index++;
                action = "shift";

                AfficherSLR();
            }
            // Réduction


            else if (Action(s,ch[index]).charAt(0) == 'r') {
                System.out.println("** Reduction par la regle **");


                String str = LRGS[Integer.parseInt(Action(s, ch[index]).substring(1))-1];
                    System.out.println(str);
                //int pos= str.indexOf('>');

                String tabparties[]= str.split("->");


                String Partiegauche=tabparties[0];
                 System.out.println("Partiegauche "+Partiegauche);

                String Partiedroite=tabparties[1];
                System.out.println("Partiedroite "+Partiedroite);

                System.out.println(Partiedroite.equals("eps"));

                if(Partiedroite.equals("epsilon")) {
                    String sommetpile = analyse.peek();
                    analyse.push(Partiegauche);
                    String tetesucc = analyse.peek();

                    analyse.push(Action(sommetpile, Partiegauche));

                    action = "reduce:" + str;
                    AfficherSLR();

                }else {

                    String tabtoken[]= Partiedroite.split(" ");
                    int taillepile= tabtoken.length +tabtoken.length;

                    for (int i = 0; i < taillepile; i++) {

                        analyse.pop();

                    }
                    String sommetpile = analyse.peek();
                    analyse.push(Partiegauche);
                    //String tetesucc = analyse.peek();

                    analyse.push(Action(sommetpile, Partiegauche));

                    action = "reduce:" + str;
                    AfficherSLR();

                }

            }


            //acceptation

            else if (Action(s,ch[index]) == "ACC")
            {
                action = "ACC";
                AfficherSLR();
                System.out.println("\n");
                System.out.println("** analyse terminee avec succes **");
                break;}

            else
            //erreur
            {
                 System.out.println("\n");
                System.out.println("texte Erreur     : " + Action(s,ch[index])+s+ch[index]+index);
                System.out.println("\n");
                System.out.println("** analyse echouee  **");
                break;
            }

        }

    }


    public void analyzeSLnew(String[] tt) {

        action = "";
        index = 0;

        analyse.push("0");


        System.out.println("********pile     	    Entrée            Action***********");
        this.AfficherSLRnew(tt);

        while(index<tt.length)

        {


            //  String s = stackState.peek();

            String s = analyse.peek();

            String act=Action(s,tt[index]);

            if (Action(s,tt[index]).charAt(0) == 's') {


                analyse.push(tt[index]);
                analyse.push(Action(s, tt[index]).substring(1));




                index++;
                action = "shift ";

                AfficherSLRnew(tt);
            }
            // Réduction
            else if (Action(s,tt[index]).charAt(0) == 'r') {
                //
                String str = LRGS[Integer.parseInt(Action(s, tt[index]).substring(1)) - 1];
                int pos= str.indexOf('>');

                String tabparties[]= str.split("->");


                String Partiegauche=tabparties[0];
                String Partiedroite=tabparties[1];
              

                if(Partiedroite.equals("epsilon")) {
                    System.out.println("dkhal fel epsilonnnn ???????S");
                    String sommetpile = analyse.peek();
                    analyse.push(Partiegauche);
                    
                    analyse.push(Action(sommetpile, Partiegauche));

                    action = "reduce:" + str;
                    AfficherSLR();

                }else {

                    String tabtoken[]= Partiedroite.split(" ");
                    int taillepile= tabtoken.length +tabtoken.length;

                    for (int i = 0; i < taillepile; i++) {
                        analyse.pop();
                    }
                    String sommetpile = analyse.peek();
                    analyse.push(Partiegauche);
                    //String tetesucc = analyse.peek();

                    analyse.push(Action(sommetpile, Partiegauche));

                    action = "reduce:" + str;
                    AfficherSLRnew(tt);

                }

            }
            //acceptation
            else if (Action(s,tt[index]) == "ACC")
            {
                System.out.println("analyze SLR successfully");
                break;}

            else
            //erreur
            {

                System.out.println("texterreur 22222222: "+Action(s,ch[index])+s+ch[index]+index);
                System.out.println("analyze SLR failled");
                break;
            }

        }

    }



    public String Action(String s, String a) {
        for (int i = 0; i < 66; i++)
            if (tableSLR[i][0].equals(s))
                for (int j = 0; j < 39; j++)
                    if (tableSLR[0][j].equals(a)) {
                        // System.out.println("ifff");
                        return tableSLR[i][j];
                    }
        return "err";
    }

    public void AfficherSLR() {
        // SLR

        String ss = "-------";
        String ss1 = "-------";
        int taillepile = analyse.size();
        int taillepilediv2 = taillepile / 2;
        for (int i = 0; i < taillepilediv2; i++)
            ss = ss + "-------";
        int tailleinput = ch.length;
        for (int i = 0; i < tailleinput; i++)
            ss1 = ss1 + "-------";

        strInput = "";
        for (int i = index; i < ch.length; i++)
            strInput = strInput + ch[i];

        System.out.printf("%s", analyse + ss1);
        System.out.printf("%s", strInput + ss);
        System.out.printf("%s", action);
        System.out.println();
    }

    public void AfficherSLRnew(String[] tt) {
        // SLR

        String ss = "-------";
        String ss1 = "-------";
        int taillepile = analyse.size();
        int taillepilediv2 = taillepile / 2;
        for (int i = 0; i < taillepilediv2; i++)
            ss = ss + "-------";
        int tailleinput = tt.length;
        for (int i = 0; i < tailleinput; i++)
            ss1 = ss1 + "-------";

        strInput = "";
        for (int i = index; i < tt.length; i++)
            strInput = strInput + tt[i];

        System.out.printf("%s", analyse + ss1);
        System.out.printf("%s", strInput + ss);
        System.out.printf("%s", action);
        System.out.println();
    }

    public void ouput() {

        System.out.println("**********Tableau SLR¨********");
        

        for (int i = 0; i < 66; i++) {
            for (int j = 0; j < 39; j++) {
                System.out.printf("%6s", tableSLR[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("**********Fin tableau SLR********");

    }

}
