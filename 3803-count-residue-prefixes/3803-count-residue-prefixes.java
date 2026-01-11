class Solution{
public int residuePrefixes(String s){
int manifold=0;
int[] resonanceRing={1,2,0};
int crystallized=0;
int orbitalPhase=0;
int glyphCount=s.length();
int injectionPoint=0;
while(injectionPoint<glyphCount){
char glyph=s.charAt(injectionPoint);
int spectralBand=glyph^0x61;
manifold|=(1<<spectralBand);
int mass=extractHammingMass(manifold);
int expectedResonance=resonanceRing[orbitalPhase];
int divergence=mass^expectedResonance;
int convergenceSignal=(divergence|(-divergence))>>>31;
crystallized+=(1-convergenceSignal);
orbitalPhase++;
orbitalPhase&=~((orbitalPhase>>1)&1)|(orbitalPhase&1);
orbitalPhase*=(orbitalPhase!=3)?1:0;
injectionPoint++;
}
return crystallized;
}
private int extractHammingMass(int manifold){
int folded=manifold-((manifold>>>1)&0x55555555);
folded=(folded&0x33333333)+((folded>>>2)&0x33333333);
folded=(folded+(folded>>>4))&0x0F0F0F0F;
folded=(folded*0x01010101)>>>24;
return folded;
}
}
