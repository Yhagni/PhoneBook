public class NrTelefoniczny implements Comparable<NrTelefoniczny>{
    private int nrKierunkowy;
    private int nrTelefonu;

    public NrTelefoniczny(int nrKierunkowy, int nrTelefonu){
        this.nrKierunkowy = nrKierunkowy;
        this.nrTelefonu = nrTelefonu;
    }

    public String toString(){       //d
        return nrKierunkowy + " " + nrTelefonu;
    }

    public int getNrKierunkowy() {
        return nrKierunkowy;
    }

    public int getNrTelefonu() {
        return nrTelefonu;
    }

    public int compareTo(NrTelefoniczny o) {
        if(this.nrKierunkowy > o.nrKierunkowy){
            return 1;
        }
        if(this.nrKierunkowy < o.nrKierunkowy){
            return -1;
        }else {
            if (this.nrTelefonu > o.nrTelefonu) {
                return 1;
            }
            if (this.nrTelefonu < o.nrTelefonu) {
                return -1;
            }
        }
        return 0;
    }

}

