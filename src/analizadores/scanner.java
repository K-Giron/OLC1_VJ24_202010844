// DO NOT EDIT
// Generated by JFlex 1.9.1 http://jflex.de/
// source: src/analizadores/lexico.jflex


package analizadores;

//importaciones
import java_cup.runtime.Symbol;
import java.util.LinkedList;
import excepciones.Errores;



@SuppressWarnings("fallthrough")
public class scanner implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = {
     0,  0,  0,  0,  0,  0,  0,  0,  0,  1,  2,  3,  2,  2,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     1,  4,  5,  0,  0,  6,  7,  8,  9, 10, 11, 12,  0, 13, 14, 15, 
    16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 17, 18, 19, 20, 21,  0, 
     0, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 31, 32, 31, 33, 34, 
    35, 31, 36, 37, 38, 39, 40, 31, 31, 31, 31,  0,  0,  0, 41, 42, 
     0, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 31, 32, 31, 33, 34, 
    35, 31, 36, 37, 38, 39, 40, 31, 31, 31, 31,  0, 43,  0,  0,  0, 
     0,  0,  0,  0,  0,  3,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0
  };

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\1\1\4\2\1\1\5"+
    "\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\12\21\1\22\1\1\1\23\1\0"+
    "\1\24\1\25\1\0\1\26\1\27\1\0\1\2\1\0"+
    "\1\30\1\31\1\32\12\21\1\33\1\0\1\34\5\21"+
    "\1\35\3\21\1\36\1\2\1\37\1\40\4\21\1\41"+
    "\3\21\1\42\1\21\1\43\1\44";

  private static int [] zzUnpackAction() {
    int [] result = new int[83];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\54\0\130\0\204\0\260\0\54\0\334\0\u0108"+
    "\0\54\0\54\0\u0134\0\54\0\54\0\u0160\0\u018c\0\54"+
    "\0\54\0\u01b8\0\u01e4\0\u0210\0\u023c\0\u0268\0\u0294\0\u02c0"+
    "\0\u02ec\0\u0318\0\u0344\0\u0370\0\u039c\0\u03c8\0\54\0\u03f4"+
    "\0\54\0\260\0\54\0\54\0\u0108\0\54\0\54\0\u0420"+
    "\0\u044c\0\u0478\0\54\0\54\0\54\0\u04a4\0\u04d0\0\u04fc"+
    "\0\u0528\0\u0554\0\u0580\0\u05ac\0\u05d8\0\u0604\0\u0630\0\54"+
    "\0\u065c\0\u0478\0\u0688\0\u06b4\0\u06e0\0\u070c\0\u0738\0\u023c"+
    "\0\u0764\0\u0790\0\u07bc\0\u023c\0\54\0\u023c\0\u023c\0\u07e8"+
    "\0\u0814\0\u0840\0\u086c\0\u023c\0\u0898\0\u08c4\0\u08f0\0\u023c"+
    "\0\u091c\0\u023c\0\u023c";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[83];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length() - 1;
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpacktrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\2\3\1\0\1\4\1\5\1\6\1\7\1\10"+
    "\1\11\1\12\1\13\1\14\1\15\1\2\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27"+
    "\1\30\1\25\1\31\2\25\1\32\4\25\1\33\1\25"+
    "\1\34\1\35\1\25\1\36\1\37\1\2\1\40\55\0"+
    "\2\3\75\0\1\41\27\0\5\42\1\43\46\42\7\0"+
    "\1\44\44\0\10\45\1\46\43\45\13\0\1\47\53\0"+
    "\1\50\3\0\1\51\52\0\1\52\1\0\1\17\57\0"+
    "\1\53\53\0\1\54\53\0\1\55\47\0\1\25\5\0"+
    "\23\25\1\0\1\25\21\0\1\25\5\0\14\25\1\56"+
    "\6\25\1\0\1\25\21\0\1\25\5\0\7\25\1\57"+
    "\4\25\1\60\6\25\1\0\1\25\21\0\1\25\5\0"+
    "\14\25\1\61\6\25\1\0\1\25\21\0\1\25\5\0"+
    "\1\62\22\25\1\0\1\25\21\0\1\25\5\0\13\25"+
    "\1\63\7\25\1\0\1\25\21\0\1\25\5\0\16\25"+
    "\1\64\4\25\1\0\1\25\21\0\1\25\5\0\20\25"+
    "\1\65\2\25\1\0\1\25\21\0\1\25\5\0\16\25"+
    "\1\66\4\25\1\0\1\25\21\0\1\25\5\0\1\67"+
    "\22\25\1\0\1\25\54\0\1\70\13\50\1\71\40\50"+
    "\2\51\2\0\50\51\20\0\1\72\53\0\1\25\5\0"+
    "\14\25\1\73\6\25\1\0\1\25\21\0\1\25\5\0"+
    "\1\74\22\25\1\0\1\25\21\0\1\25\5\0\13\25"+
    "\1\75\7\25\1\0\1\25\21\0\1\25\5\0\21\25"+
    "\1\76\1\25\1\0\1\25\21\0\1\25\5\0\12\25"+
    "\1\77\10\25\1\0\1\25\21\0\1\25\5\0\20\25"+
    "\1\100\2\25\1\0\1\25\21\0\1\25\5\0\10\25"+
    "\1\101\12\25\1\0\1\25\21\0\1\25\5\0\16\25"+
    "\1\102\4\25\1\0\1\25\21\0\1\25\5\0\21\25"+
    "\1\103\1\25\1\0\1\25\21\0\1\25\5\0\16\25"+
    "\1\104\4\25\1\0\1\25\1\0\13\50\1\71\3\50"+
    "\1\105\34\50\20\0\1\25\5\0\12\25\1\106\10\25"+
    "\1\0\1\25\21\0\1\25\5\0\16\25\1\107\4\25"+
    "\1\0\1\25\21\0\1\25\5\0\17\25\1\110\3\25"+
    "\1\0\1\25\21\0\1\25\5\0\1\25\1\111\21\25"+
    "\1\0\1\25\21\0\1\25\5\0\17\25\1\103\3\25"+
    "\1\0\1\25\21\0\1\25\5\0\13\25\1\112\7\25"+
    "\1\0\1\25\21\0\1\25\5\0\10\25\1\113\12\25"+
    "\1\0\1\25\21\0\1\25\5\0\4\25\1\114\16\25"+
    "\1\0\1\25\21\0\1\25\5\0\20\25\1\104\2\25"+
    "\1\0\1\25\21\0\1\25\5\0\12\25\1\115\10\25"+
    "\1\0\1\25\21\0\1\25\5\0\20\25\1\116\2\25"+
    "\1\0\1\25\21\0\1\25\5\0\13\25\1\117\7\25"+
    "\1\0\1\25\21\0\1\25\5\0\4\25\1\120\16\25"+
    "\1\0\1\25\21\0\1\25\5\0\12\25\1\121\10\25"+
    "\1\0\1\25\21\0\1\25\5\0\6\25\1\122\14\25"+
    "\1\0\1\25\21\0\1\25\5\0\13\25\1\123\7\25"+
    "\1\0\1\25\1\0";

  private static int [] zzUnpacktrans() {
    int [] result = new int[2376];
    int offset = 0;
    offset = zzUnpacktrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpacktrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\3\1\1\11\2\1\2\11\1\1\2\11"+
    "\2\1\2\11\15\1\1\11\1\1\1\11\1\0\2\11"+
    "\1\0\2\11\1\0\1\1\1\0\3\11\12\1\1\11"+
    "\1\0\13\1\1\11\16\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[83];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen())];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */

    public LinkedList<Errores> listaErrores = new LinkedList<Errores>();

    



  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public scanner(java.io.Reader in) {
      yyline = 1;
    yycolumn = 1;
    listaErrores = new LinkedList<Errores>();
    this.zzReader = in;
  }


  /** Returns the maximum size of the scanner buffer, which limits the size of tokens. */
  private int zzMaxBufferLen() {
    return Integer.MAX_VALUE;
  }

  /**  Whether the scanner buffer can grow to accommodate a larger token. */
  private boolean zzCanGrow() {
    return true;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    return ZZ_CMAP[input];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate && zzCanGrow()) {
      /* if not, and it can grow: blow it up */
      char newBuffer[] = new char[Math.min(zzBuffer.length * 2, zzMaxBufferLen())];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      if (requested == 0) {
        throw new java.io.EOFException("Scan buffer limit reached ["+zzBuffer.length+"]");
      }
      else {
        throw new java.io.IOException(
            "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
      }
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    int initBufferSize = Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen());
    if (zzBuffer.length > initBufferSize) {
      zzBuffer = new char[initBufferSize];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
  yyclose();    }
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  @Override  public java_cup.runtime.Symbol next_token() throws java.io.IOException
  {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { return new java_cup.runtime.Symbol(sym.EOF); }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { listaErrores.add(new Errores("Error lexico", "El caracter "+yytext()+" no pertence al lenguaje", yyline, yycolumn));
            }
          // fall through
          case 37: break;
          case 2:
            { 
            }
          // fall through
          case 38: break;
          case 3:
            { return new Symbol(sym.NOT, yyline, yycolumn,yytext());
            }
          // fall through
          case 39: break;
          case 4:
            { return new Symbol(sym.MODULO, yyline, yycolumn,yytext());
            }
          // fall through
          case 40: break;
          case 5:
            { return new Symbol(sym.PAR1, yyline, yycolumn,yytext());
            }
          // fall through
          case 41: break;
          case 6:
            { return new Symbol(sym.PAR2, yyline, yycolumn,yytext());
            }
          // fall through
          case 42: break;
          case 7:
            { return new Symbol(sym.MULTIPLICACION, yyline, yycolumn,yytext());
            }
          // fall through
          case 43: break;
          case 8:
            { return new Symbol(sym.MAS, yyline, yycolumn,yytext());
            }
          // fall through
          case 44: break;
          case 9:
            { return new Symbol(sym.MENOS, yyline, yycolumn,yytext());
            }
          // fall through
          case 45: break;
          case 10:
            { return new Symbol(sym.DIVISION, yyline, yycolumn,yytext());
            }
          // fall through
          case 46: break;
          case 11:
            { return new Symbol(sym.ENTERO, yyline, yycolumn,yytext());
            }
          // fall through
          case 47: break;
          case 12:
            { return new Symbol(sym.DOSPUNTOS, yyline, yycolumn,yytext());
            }
          // fall through
          case 48: break;
          case 13:
            { return new Symbol(sym.FINCADENA, yyline, yycolumn,yytext());
            }
          // fall through
          case 49: break;
          case 14:
            { return new Symbol(sym.MENOR, yyline, yycolumn,yytext());
            }
          // fall through
          case 50: break;
          case 15:
            { return new Symbol(sym.IGUAL, yyline, yycolumn,yytext());
            }
          // fall through
          case 51: break;
          case 16:
            { return new Symbol(sym.MAYOR, yyline, yycolumn,yytext());
            }
          // fall through
          case 52: break;
          case 17:
            { return new Symbol(sym.ID, yyline, yycolumn,yytext());
            }
          // fall through
          case 53: break;
          case 18:
            { return new Symbol(sym.XOR, yyline, yycolumn,yytext());
            }
          // fall through
          case 54: break;
          case 19:
            { return new Symbol(sym.DIFERENTE, yyline, yycolumn,yytext());
            }
          // fall through
          case 55: break;
          case 20:
            { String cadena = yytext();
    cadena = cadena.substring(1, cadena.length()-1);
    return new Symbol(sym.CADENA, yyline, yycolumn,cadena);
            }
          // fall through
          case 56: break;
          case 21:
            { return new Symbol(sym.AND, yyline, yycolumn,yytext());
            }
          // fall through
          case 57: break;
          case 22:
            { String caracter = yytext();
    caracter = caracter.substring(1, caracter.length()-1);
    return new Symbol(sym.CARACTER, yyline, yycolumn,caracter);
            }
          // fall through
          case 58: break;
          case 23:
            { return new Symbol(sym.POTENCIA, yyline, yycolumn,yytext());
            }
          // fall through
          case 59: break;
          case 24:
            { return new Symbol(sym.MENORQUE, yyline, yycolumn,yytext());
            }
          // fall through
          case 60: break;
          case 25:
            { return new Symbol(sym.IGUALACION, yyline, yycolumn,yytext());
            }
          // fall through
          case 61: break;
          case 26:
            { return new Symbol(sym.MAYORQUE, yyline, yycolumn,yytext());
            }
          // fall through
          case 62: break;
          case 27:
            { return new Symbol(sym.OR, yyline, yycolumn,yytext());
            }
          // fall through
          case 63: break;
          case 28:
            { return new Symbol(sym.DECIMAL, yyline, yycolumn,yytext());
            }
          // fall through
          case 64: break;
          case 29:
            { return new Symbol(sym.INT, yyline, yycolumn,yytext());
            }
          // fall through
          case 65: break;
          case 30:
            { return new Symbol(sym.MUTABILIDAD, yyline, yycolumn,yytext());
            }
          // fall through
          case 66: break;
          case 31:
            { return new Symbol(sym.BOOL, yyline, yycolumn,yytext());
            }
          // fall through
          case 67: break;
          case 32:
            { return new Symbol(sym.CHAR, yyline, yycolumn,yytext());
            }
          // fall through
          case 68: break;
          case 33:
            { return new Symbol(sym.BOOLEANO, yyline, yycolumn,yytext());
            }
          // fall through
          case 69: break;
          case 34:
            { return new Symbol(sym.DOUBLE, yyline, yycolumn,yytext());
            }
          // fall through
          case 70: break;
          case 35:
            { return new Symbol(sym.STRING, yyline, yycolumn,yytext());
            }
          // fall through
          case 71: break;
          case 36:
            { return new Symbol(sym.IMPRIMIR, yyline, yycolumn,yytext());
            }
          // fall through
          case 72: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
