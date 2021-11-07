package moves;

import ru.ifmo.se.pokemon.*;

public class FireBlast extends SpecialMove {
    public FireBlast(){
        super(Type.FIRE,110,85);
    }

    @Override
    protected void applyOppEffects(Pokemon def) {
        Type[] types = def.getTypes();
        boolean isFire = false;
        for(int i =0;i<types.length;i++){
            if(types[i].equals(Type.FIRE) ){
                isFire=true;
            }
        }

        if(!isFire){
            int n=(int) ((Math.random() * (10 - 1)) + 1);
            if(n==1){
                Effect.burn(def);
            }
        }
    }

    @Override
    protected String describe() {
        return "использует Fire Blast";
    }
}
